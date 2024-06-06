package minkostplan.application.DBcontroller.recipe;

import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.entity.Recipe;

import minkostplan.application.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        recipe.setCreatedAt(LocalDateTime.now());
        try{
            String sql = "INSERT INTO recipes (name, cook_name, average_time, created_at, instructions, meal_type) VALUES (?, ?, ?, ?, ?)";
            dataAccess.getJdbcTemplate().update(sql, recipe.getName(), recipe.getCookName(), recipe.getAverageTime(), recipe.getCreatedAt(), recipe.getInstructions(), recipe.getMealType());
        } catch (DuplicateKeyException e){
            System.out.println("same name as another recipe" + e.getMessage());
        }

    }

    @Override
    public int getIdByRecipeName(String name){
        String sql = "SELECT recipe_id FROM recipes WHERE name =?";
        return jdbcTemplate.queryForObject(sql, Integer.class,name);
    }

    @Override
    public Recipe getRecipeById(int id) {
        Recipe recipe = findByProperty("recipe_id", id);
        if (recipe != null) {
            String sql = "SELECT ri.quantity, i.name AS ingredient_name FROM recipe_ingredients ri " +
                    "JOIN ingredients i ON ri.ingredient_id = i.ingredient_id " +
                    "WHERE ri.recipe_id = ?";
            List<RecipeIngredient> ingredients = jdbcTemplate.query(sql, ps -> ps.setInt(1, id), (rs, rowNum) -> {
                RecipeIngredient ingredient = new RecipeIngredient();
                ingredient.setQuantity(rs.getString("quantity"));
                ingredient.setIngredientName(rs.getString("ingredient_name"));
                return ingredient;
            });
            recipe.setIngredients(ingredients);
        }
        return recipe;
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        String sql = "DELETE FROM recipes WHERE name = ?";
        dataAccess.getJdbcTemplate().update(sql, recipe.getName());
    }

    @Override
    public void editRecipe(Recipe recipe, int recipeId) {
        String sql = "UPDATE recipes SET name = ?, average_time = ?, instructions = ?, meal_type = ? WHERE recipe_id = ?";
        dataAccess.getJdbcTemplate().update(sql, recipe.getName(), recipe.getAverageTime(), recipe.getInstructions(), recipe.getMealType(), recipeId);
    }

    @Override
    public Recipe findByProperty(String property, Object value) {
        return dataAccess.findByProperty(property,value);
    }

    @Override
    public List<Recipe> findAll() {
        String sqlRecipes = "SELECT * FROM recipes";
        String sqlIngredients = "SELECT ri.recipe_id, ri.ingredient_id, ri.quantity, i.name AS ingredient_name FROM recipe_ingredients ri JOIN ingredients i ON ri.ingredient_id = i.ingredient_id";

        try {
            List<Recipe> recipes = jdbcTemplate.query(sqlRecipes, (rs, rowNum) -> {
                Recipe recipe = new Recipe();
                recipe.setRecipe_id(rs.getInt("recipe_id"));
                recipe.setName(rs.getString("name"));
                recipe.setCookName(rs.getString("cook_name"));
                recipe.setAverageTime(rs.getInt("average_time"));
                recipe.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                recipe.setInstructions(rs.getString("instructions"));
                recipe.setMealType(rs.getString("meal_type"));
                return recipe;
            });

            List<RecipeIngredient> ingredients = jdbcTemplate.query(sqlIngredients, (rs, rowNum) -> {
                RecipeIngredient ri = new RecipeIngredient();
                ri.setRecipeid(rs.getInt("recipe_id"));
                ri.setIngredientid(rs.getInt("ingredient_id"));
                ri.setQuantity(rs.getString("quantity"));
                ri.setIngredientName(rs.getString("ingredient_name"));
                return ri;
            });

            Map<Integer, List<RecipeIngredient>> ingredientsMap = ingredients.stream()
                    .collect(Collectors.groupingBy(RecipeIngredient::getRecipeid));

            recipes.forEach(recipe -> recipe.setIngredients(ingredientsMap.get(recipe.getRecipe_id())));
            System.out.println("Retrieved recipes: " + recipes);
            return recipes;
        } catch (Exception e) {
            System.err.println("Error accessing database: " + e.getMessage());
            return List.of(); // Return empty list if error
        }
    }

    @Override
    public List<Recipe> findAllRecipe() {
        return dataAccess.findAll();
    }
}
