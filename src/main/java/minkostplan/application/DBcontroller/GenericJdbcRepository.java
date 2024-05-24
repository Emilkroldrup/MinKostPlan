package minkostplan.application.DBcontroller;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * Generic JDBC repository for data access operations.
 *
 * @param <T> the type of the entity
 */
public class GenericJdbcRepository<T> implements SimpleDataAccess<T> {
    private JdbcTemplate jdbcTemplate;
    private Class<T> type;

    /**
     * Constructs a new GenericJdbcRepository.
     *
     * @param jdbcTemplate the JdbcTemplate instance
     * @param type the class type of the entity
     */
    public GenericJdbcRepository(JdbcTemplate jdbcTemplate, Class<T> type) {
        this.jdbcTemplate = jdbcTemplate;
        this.type = type;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
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

    public void save(T entity, String sql, Object... args) {
        jdbcTemplate.update(sql, args);
    }

    private String getTableName(Class<T> type) {
        String className = type.getSimpleName();
        if (className.equals("Recipe")) {
            return "recipes";
        } else if(className.equals("Ingredient")){
            return "ingredients";
        }else {
            return className.toLowerCase();
        }
    }
}
