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
    public Users findByName(String firstName, String lastName) {
        return findByProperty("'firstname'" + firstName + "'lastname'" + lastName, lastName);
    }

    @Override
    public Users findByEmail(String email) {
        return findByProperty("email", email);
    }

    @Override
    public void save(Users user) {
        String sql = "INSERT INTO users (firstname, lastname, age, height, weight, gender, goal, email, password_hash, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        dataAccess.getJdbcTemplate().update(sql, user.getFirstName(), user.getLastName(), user.getAge(), user.getHeight(), user.getWeight(), user.getGender(), user.getGoal(), user.getEmail(), user.getPasswordHash(), user.getCreatedAt());
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
            String sql = "UPDATE users SET firstname = COALESCE(?, firstname), email = COALESCE(?, email) WHERE email =?";
            if( !users.getFirstName().isEmpty() && !users.getEmail().isEmpty()){
                jdbcTemplate.update(sql, users.getFirstName(), users.getEmail(), currentuser.getEmail());
            }
        } catch (DuplicateKeyException duplicateKeyException){
            System.out.println("duplicatekey error, same user-details already exists" + duplicateKeyException);
        } catch (Exception e) {
            System.out.println("Error trying to update user: " + e.getMessage());
        }
    }
}
