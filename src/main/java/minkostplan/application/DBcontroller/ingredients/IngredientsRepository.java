package minkostplan.application.DBcontroller.ingredients;

import minkostplan.application.entity.Ingredient;
import minkostplan.application.DBcontroller.SimpleDataAccess;

public interface IngredientsRepository extends SimpleDataAccess<Ingredient> {

    /**
     *
     * @param ingredient
     */
    void saveIngredient(Ingredient ingredient);

    /**
     *
     * @param ingredient
     */
    void deleteIngredient(Ingredient ingredient);

    /**
     *
     * @param ingredient
     */
    void editIngredient(Ingredient ingredient);

}
