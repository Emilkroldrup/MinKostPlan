package minkostplan.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RecipeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RecipeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Recipe> findAll() {
        return jdbcTemplate.query("SELECT * FROM recipes", new RecipeRowMapper());
        // Test start of SQL injection
    }

}
