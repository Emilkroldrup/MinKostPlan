package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.GenericJdbcRepository;

import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private GenericJdbcRepository<Users> dataAccess;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataAccess = new GenericJdbcRepository<>(jdbcTemplate, Users.class);
    }

    @Override
    public Users findByUsername(String username) {
        return findByProperty("username", username);
    }

    @Override
    public Users findByEmail(String email) {
        return findByProperty("email", email);
    }

    @Override
    public Users findByProperty(String property, Object value) {
        return dataAccess.findByProperty(property, value);
    }

    @Override
    public List<Users> findAll() {
        return dataAccess.findAll();
    }

    @Override
    public void editUserDetails(Users users) {
        Users currentuser = UserUtil.getCurrentUser();
        try {
            String sql = "UPDATE users SET username = COALESCE(?, username), email = COALESCE(?, email) WHERE email =?";
            if( !users.getUsername().isEmpty() && !users.getEmail().isEmpty()){
                jdbcTemplate.update(sql, users.getUsername(), users.getEmail(), currentuser.getEmail());
            }
        } catch (DuplicateKeyException duplicateKeyException){
            System.out.println("duplicatekey error, same user-details already exists" + duplicateKeyException);
        } catch (Exception e) {
            System.out.println("Error trying to update user: " + e.getMessage());
        }
    }
}
