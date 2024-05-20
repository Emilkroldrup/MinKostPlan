package minkostplan.application.entity;

/**
 * Represents an ingredient entity.
 */
public class Ingredient {

    private Long ingredientId;
    private String name;
    private String description;

    /**
     * Default constructor.
     */
    public Ingredient() {
    }

    /**
     * Constructs a new Ingredient with specified details.
     *
     * @param ingredientId the ID of the ingredient
     * @param name the name of the ingredient
     * @param description the description of the ingredient
     */
    public Ingredient(Long ingredientId, String name, String description) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
