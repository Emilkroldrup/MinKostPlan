package minkostplan.application.DBcontroller.ingredients;

import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.entity.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<String> findAllNames() {
        String sql = "SELECT name FROM ingredients";
        return jdbcTemplate.queryForList(sql, String.class);
    }
    @Override
    public void saveIngredient(Ingredient ingredient) {
        String sql = "INSERT INTO ingredients (name, description,calories,carbohydrate,fat,protein) VALUES (?,?,?,?,?,?)";
        dataAccess.getJdbcTemplate().update(sql, ingredient.getName(), ingredient.getDescription(),ingredient.getCalories(),ingredient.getCarbohydrate(),ingredient.getFat(),ingredient.getProtein());
    }

    @Override
    public int getIdByIngredientName(String name){
        String sql = "SELECT ingredient_id FROM ingredients WHERE name = ? LIMIT 1";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }

    @Override
    public Ingredient getIngredientById(int id){
        return findByProperty("ingredient_id", id);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        String sql = "DELETE FROM ingredients WHERE ingredient_id = ?";
        dataAccess.getJdbcTemplate().update(sql, ingredient.getIngredientId());
    }

    @Override
    public void editIngredient(Ingredient ingredient, int ingredientId) {
        String sql = "UPDATE ingredients SET name = ?, description = ?, calories = ?, carbohydrate = ?, fat = ?, protein = ? WHERE ingredient_id = ?";
        dataAccess.getJdbcTemplate().update(sql, ingredient.getName(), ingredient.getDescription(),ingredient.getCalories(),ingredient.getCarbohydrate(), ingredient.getFat(), ingredient.getProtein(), ingredientId);
    }

    @Override
    public Ingredient findByProperty(String property, Object value) {
        return dataAccess.findByProperty(property,value);
    }

    @Override
    public List<Ingredient> findAll() {
        return dataAccess.findAll();
    }
}
