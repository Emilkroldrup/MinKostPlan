package minkostplan.application.entity;

/**
 * Represents an ingredient entity.
 */
public class Ingredient {

    private Long ingredientId;
    private String name;
    private String description;

    private int calories;
    private int carbohydrate;
    private int fat;
    private int protein;

    /**
     * Default constructor.
     */
    public Ingredient() {
    }
    
    /**
     * @param ingredientId the id of the ingregredien
     * @param name the name of the ingredient
     * @param description the descripton of the ingredient
     * @param calories the amount of calories per 100/gram or 100/ml in an ingredient
     * @param carbohydrate the amount of carbohydrate per 100/gram or 100/ml in an ingredient
     * @param fat the amount of fat per 100/gram or 100/ml in an ingredient 
     * @param protein the amount of protein per 100/gram or 100/ml in an ingredient
     */
    public Ingredient(Long ingredientId, String name, String description, int calories, int carbohydrate, int fat, int protein) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.protein = protein;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", carbohydrate=" + carbohydrate +
                ", fat=" + fat +
                ", protein=" + protein +
                '}';
    }
}
