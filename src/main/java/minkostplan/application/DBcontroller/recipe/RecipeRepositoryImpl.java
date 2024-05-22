package minkostplan.application.DBcontroller.recipe;

import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.entity.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {
    private GenericJdbcRepository<Recipe> dataAccess;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RecipeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataAccess = new GenericJdbcRepository<>(jdbcTemplate, Recipe.class);
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipes (name, cook_name, average_time, created_at) VALUES (?, ?, ?, ?)";
        dataAccess.getJdbcTemplate().update(sql, recipe.getName(), recipe.getCookName(), recipe.getAverageTime(), recipe.getCreatedAt());
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        String sql = "DELETE FROM recipes WHERE name = ?";
        dataAccess.getJdbcTemplate().update(sql, recipe.getName());
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        String sql = "UPDATE recipes SET name = ?, average_time = ? WHERE name = ?";
        dataAccess.getJdbcTemplate().update(sql, recipe.getName(), recipe.getAverageTime(), recipe.getName());
    }

    @Override
    public Recipe findByProperty(String property, Object value) {
        return null;
    }

    @Override
    public List<Recipe> findAll() {
        return List.of();
    }
}
