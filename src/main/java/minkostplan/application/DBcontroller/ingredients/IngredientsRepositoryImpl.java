package minkostplan.application.DBcontroller.ingredients;

import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.entity.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngredientsRepositoryImpl implements IngredientsRepository {
    private GenericJdbcRepository<Ingredient> dataAccess;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataAccess = new GenericJdbcRepository<>(jdbcTemplate, Ingredient.class);
    }

    @Override
    public void saveIngredient(Ingredient ingredient) {
            String sql = "INSERT INTO ingredients (name, description) VALUES (?, ?)";
            dataAccess.getJdbcTemplate().update(sql, ingredient.getName(), ingredient.getDescription());
    }

    @Override
    public int getIdByIngredientName(String name){
            String sql = "SELECT ingredient_id FROM ingredients WHERE name = ? LIMIT 1";
            return jdbcTemplate.queryForObject(sql, Integer.class, name);

    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        String sql = "DELETE FROM ingredients WHERE ingredient_id = ?";
        dataAccess.getJdbcTemplate().update(sql, ingredient.getIngredientId());
    }

    @Override
    public void editIngredient(Ingredient ingredient) {
        String sql = "UPDATE ingredients SET name = ?, description = ? WHERE ingredient_id = ?";
        dataAccess.getJdbcTemplate().update(sql, ingredient.getName(), ingredient.getDescription(), ingredient.getIngredientId());
    }

    @Override
    public Ingredient findByProperty(String property, Object value) {
        return dataAccess.findByProperty(property,value);
    }

    @Override
    public List<Ingredient> findAll() {
        return List.of();
    }
}
