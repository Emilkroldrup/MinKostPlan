package minkostplan.application.DBcontroller.recipe;

import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.entity.Recipe;
import minkostplan.application.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {
    private final GenericJdbcRepository<Recipe> dataAccess;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RecipeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataAccess = new GenericJdbcRepository<>(jdbcTemplate, Recipe.class);
    }

    @Override
    @Transactional
    public void saveRecipe(Recipe recipe) {
        recipe.setCreatedAt(LocalDateTime.now());
        try {
            String sql = "INSERT INTO recipes (name, cook_name, average_time, created_at, instructions) VALUES (?, ?, ?, ?, ?)";
            dataAccess.getJdbcTemplate().update(sql, recipe.getName(), recipe.getCookName(), recipe.getAverageTime(), recipe.getCreatedAt(), recipe.getInstructions());
        } catch (DuplicateKeyException e) {
            System.err.println("Duplicate recipe name: " + e.getMessage());
        }
    }

    @Override
    public int getIdByRecipeName(String name) {
        String sql = "SELECT recipe_id FROM recipes WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }

    @Override
    public Recipe getRecipeById(int id){
        return findByProperty("recipe_id", id);
    }

    @Override
    @Transactional
    public void deleteRecipe(Recipe recipe) {
        String sql = "DELETE FROM recipes WHERE name = ?";
        dataAccess.getJdbcTemplate().update(sql, recipe.getName());
    }

    @Override
    @Transactional
    public void editRecipe(Recipe recipe, int recipeId) {
        String sql = "UPDATE recipes SET name = ?, average_time = ? WHERE recipe_id = ?";
        dataAccess.getJdbcTemplate().update(sql, recipe.getName(), recipe.getAverageTime(), recipeId);
    }

    @Override
    public Recipe findByProperty(String property, Object value) {
        return dataAccess.findByProperty(property, value);
    }

    @Override
    public List<Recipe> findAll() {
        String sqlRecipes = "SELECT * FROM recipes";
        String sqlIngredients = "SELECT * FROM recipe_ingredients";

        try {
            List<Recipe> recipes = jdbcTemplate.query(sqlRecipes, (rs, rowNum) -> {
                Recipe recipe = new Recipe();
                recipe.setRecipe_id(rs.getInt("recipe_id"));
                recipe.setName(rs.getString("name"));
                recipe.setCookName(rs.getString("cook_name"));
                recipe.setAverageTime(rs.getInt("average_time"));
                recipe.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                recipe.setInstructions(rs.getString("instructions"));
                return recipe;
            });

            List<RecipeIngredient> ingredients = jdbcTemplate.query(sqlIngredients, (rs, rowNum) -> {
                RecipeIngredient ri = new RecipeIngredient();
                ri.setRecipeid(rs.getInt("recipe_id"));
                ri.setIngredientid(rs.getInt("ingredient_id"));
                ri.setQuantity(rs.getString("quantity"));
                return ri;
            });

            Map<Integer, List<RecipeIngredient>> ingredientsMap = ingredients.stream()
                .collect(Collectors.groupingBy(RecipeIngredient::getRecipeid));

            recipes.forEach(recipe -> recipe.setIngredients(ingredientsMap.get(recipe.getRecipe_id())));

            return recipes;
        } catch (Exception e) {
            System.err.println("Error accessing database: " + e.getMessage());
            return List.of(); 
        }
    }
}
