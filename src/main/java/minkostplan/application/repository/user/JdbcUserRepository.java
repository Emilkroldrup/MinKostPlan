package minkostplan.application.repository.user;

import minkostplan.application.entity.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Gives a specific user by using its username
     *
     * @param username
     * @return the user with the given username
     */
    @Override
    public Users findByUsername(String username) {
        try{
            String sql = "SELECT * FROM users WHERE username = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Users(
                    rs.getInt("user_Id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password_hash"),
                    rs.getTimestamp("created_at").toLocalDateTime()
            ), username);
        } catch(Exception e){
            throw new RuntimeException("Failed to get user by username: " + e.getMessage());
        }
    }

    /**
     * Retrieves all users from the database.
     *
     * @return a list of all users
     */
    public List<Users> getAllUsers() {
        try {
            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql, (rs, rowNum) -> new Users(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password_hash"),
                    rs.getTimestamp("created_at").toLocalDateTime()
            ));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all users: " + e.getMessage());
        }
    }
}
