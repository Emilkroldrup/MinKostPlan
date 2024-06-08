package minkostplan.application.DBcontroller.recipeingredient;

import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
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
    public RecipeIngredient getRecipeIngredientByIngredientId(int ingredientId){
        RecipeIngredient recipeIngredient = findByProperty("ingredient_id", ingredientId);
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
