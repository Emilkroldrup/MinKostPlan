package minkostplan.application.repository.user;

import minkostplan.application.entity.User;

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
    public User findByUsername(String username) {
        try{
            String sql = "SELECT * FROM user WHERE username = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new User(
                    rs.getLong("userId"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("passwordHash"),
                    rs.getTimestamp("createdAt").toLocalDateTime()
            ), username);
        } catch(Exception e){
            throw new RuntimeException("Failed to get user by username: " + e.getMessage());
        }
    }
}
