package minkostplan.application.DBcontroller.recipeingredient;

import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecepiIngredientRepositoryImpl implements RecepiIngredientRepository{


    private GenericJdbcRepository<RecipeIngredient> dataAccess;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RecepiIngredientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataAccess = new GenericJdbcRepository<>(jdbcTemplate, RecipeIngredient.class);
    }


    @Override
    public void saveRecipeIngredient(RecipeIngredient recipeIngredient){
        String sql = "INSERT INTO recipe_ingredients (recipe_id,ingredient_id,quantity) VALUES (?,?,?)";
        jdbcTemplate.update(sql,recipeIngredient.getRecipeid(),recipeIngredient.getIngredientid(),recipeIngredient.getQuantity());
    }


    @Override
    public RecipeIngredient getRecipeIngredientById(int ingredientId, int recipeId){
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        String sql = "SELECT * FROM recipe_ingredients WHERE recipe_id = ? AND ingredient_id = ?";
        recipeIngredient = dataAccess.getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(RecipeIngredient.class), recipeId, ingredientId);
        return recipeIngredient;
    }

    @Override
    public RecipeIngredient findByProperty(String property, Object value) {
        return dataAccess.findByProperty(property, value);
    }

    @Override
    public List<RecipeIngredient> findAll() {
        return List.of();
    }
}
