package minkostplan.application.entity;

/**
 * Represents a relationship between a recipe and an ingredient.
 */
public class RecipeIngredient {

    private Recipe recipe;
    private Ingredient ingredient;
    private String quantity;

    /**
     * Default constructor.
     */
    public RecipeIngredient() {
    }

    /**
     * Constructs a new RecipeIngredient with specified details.
     *
     * @param recipe the recipe
     * @param ingredient the ingredient
     * @param quantity the quantity of the ingredient
     */
    public RecipeIngredient(Recipe recipe, Ingredient ingredient, String quantity) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
            " recipe='" + getRecipe() + "'" +
            ", ingredient='" + getIngredient() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }
}
