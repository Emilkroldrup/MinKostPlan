package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.GenericJdbcRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private GenericJdbcRepository<Users> dataAccess;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.dataAccess = new GenericJdbcRepository<>(jdbcTemplate, Users.class);
    }

    @Override
    public Users findByUsername(String username) {
        return findByProperty("username", username);
    }

    @Override
    public Users getUserByEmail(String email) {
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
}
