package minkostplan.application.DBcontroller.recipe;

import minkostplan.application.DBcontroller.SimpleDataAccess;
import minkostplan.application.entity.Recipe;



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
}
