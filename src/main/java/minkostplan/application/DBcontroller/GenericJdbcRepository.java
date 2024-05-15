package minkostplan.application.DBcontroller;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class GenericJdbcRepository<T> implements SimpleDataAccess<T> {
    private JdbcTemplate jdbcTemplate;
    private Class<T> type;

    public GenericJdbcRepository(JdbcTemplate jdbcTemplate, Class<T> type) {
        this.jdbcTemplate = jdbcTemplate;
        this.type = type;
    }

    @Override
    public T findByProperty(String property, Object value) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", getTableName(type), property);
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(type), value);
    }

    @Override
    public List<T> findAll() {
        String sql = String.format("SELECT * FROM %s", getTableName(type));
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(type));
    }

    private String getTableName(Class<T> type) {
        return type.getSimpleName().toLowerCase();
    }
}
