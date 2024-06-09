package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Implementation of the UserRepository interface.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private GenericJdbcRepository<Users> dataAccess;
    private JdbcTemplate jdbcTemplate;

     /**
     * Constructs a new UserRepositoryImpl.
     *
     * @param jdbcTemplate the JdbcTemplate instance
     */
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
    public void saveUser(Users user) {
        String sql = "INSERT INTO users (firstname, lastname, age, height, weight, gender, goal, email, password_hash, created_at, activitylevel, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        dataAccess.getJdbcTemplate().update(sql, user.getFirstName(), user.getLastName(), user.getAge(), user.getHeight(), user.getWeight(), user.getGender(), user.getGoal(), user.getEmail(), user.getPasswordHash(), user.getCreatedAt(),user.getActivityLevel(), user.getPhone());
    }
    @Override
    public void editUserDetails(Users user) {
        Users currentuser = UserUtil.getCurrentUser();
        String sql = "UPDATE users SET firstname = ?, lastname = ?, email = ?, age = ?, height = ?, weight = ?, gender = ?, goal = ?, activitylevel = ? WHERE email = ?";
        if (!user.getFirstName().isEmpty() && !user.getLastName().isEmpty() && !user.getEmail().isEmpty() && user.getAge() >= 0 && user.getHeight() >= 0 && user.getWeight() >= 0 && !user.getGender().isEmpty() && !user.getGoal().isEmpty() && !user.getActivityLevel().isEmpty()) {
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getHeight(), user.getWeight(), user.getGender(), user.getGoal(), user.getActivityLevel(), currentuser.getEmail());
        }
    }
    @Override
    public Users findByProperty(String property, Object value) {
        return dataAccess.findByProperty(property, value);
    }
    @Override
    public List<Users> findAll() {
        return dataAccess.findAll();
    }

}
