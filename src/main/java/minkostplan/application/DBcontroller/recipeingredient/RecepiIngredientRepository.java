package minkostplan.application.DBcontroller.recipeingredient;

import minkostplan.application.DBcontroller.SimpleDataAccess;
import minkostplan.application.entity.RecipeIngredient;

public  interface  RecepiIngredientRepository  extends SimpleDataAccess<RecipeIngredient> {
    void saveRecipeIngredient(RecipeIngredient recipeIngredient);

    RecipeIngredient getRecipeIngredientById(int ingredientId, int recipeId);
}
