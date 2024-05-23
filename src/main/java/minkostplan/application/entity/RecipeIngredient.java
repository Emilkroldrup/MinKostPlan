package minkostplan.application.entity;

/**
 * Represents a relationship between a recipe and an ingredient.
 */
public class RecipeIngredient {

    private int recipeid;
    private int ingredientid;
    private String quantity;

    /**
     * Default constructor.
     */
    public RecipeIngredient() {
    }

    /**
     * Constructs a new RecipeIngredient with specified details.
     *
     * @param recipeid the recipeid
     * @param ingredientid the ingredientid
     * @param quantity the quantity of the ingredient
     */
    public RecipeIngredient(int recipeid, int ingredientid, String quantity) {
        this.recipeid = recipeid;
        this.ingredientid = ingredientid;
        this.quantity = quantity;
    }

    public int getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(int recipeid) {
        this.recipeid = recipeid;
    }

    public int getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(int ingredientid) {
        this.ingredientid = ingredientid;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeid=" + recipeid +
                ", ingredientid=" + ingredientid +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
