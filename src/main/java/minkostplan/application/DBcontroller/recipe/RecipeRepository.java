package minkostplan.application.DBcontroller.recipe;

import minkostplan.application.DBcontroller.SimpleDataAccess;
import minkostplan.application.entity.Recipe;

import java.util.List;


public interface RecipeRepository extends SimpleDataAccess<Recipe> {

    /**
     *
     * @param recipe
     */
    void saveRecipe(Recipe recipe);

    int getIdByRecipeName(String name);

    Recipe getRecipeById(int id);

    /**
     *
     * @param recipe
     */
    void deleteRecipe(Recipe recipe);

    void editRecipe(Recipe recipe, int recipeId);

    List<Recipe> findAllRecipe();
}
