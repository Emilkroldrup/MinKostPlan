package minkostplan.application.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a recipe entity.
 */
public class Recipe {

    private String name;
    private int recipe_id;
    private String cookName;
    private Integer averageTime;
    private LocalDateTime createdAt;
    private String instructions;
    private List<RecipeIngredient> ingredients;
    private String mealType;
    private List<String> instructionsList;

    // Default constructor
    public Recipe() {
    }

    // Constructor with all fields
    public Recipe(String name, String cookName, Integer averageTime, LocalDateTime createdAt, String instructions, String mealType) {
        this.name = name;
        this.cookName = cookName;
        this.averageTime = averageTime;
        this.createdAt = createdAt;
        this.instructions = instructions;
        this.mealType = mealType;
    }

    public Recipe(Integer id, String name, String cookName, Integer averageTime, LocalDateTime createdAt, String instructions, String mealType) {
        this.recipe_id = id;
        this.name = name;
        this.cookName = cookName;
        this.averageTime = averageTime;
        this.createdAt = createdAt;
        this.instructions = instructions;
        this.mealType = mealType;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public Integer getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Integer averageTime) {
        this.averageTime = averageTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Integer recipe_id) {
        this.recipe_id = recipe_id;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public List<String> getInstructionsList() {
        return instructionsList;
    }

    public void setInstructionsList(List<String> instructionsList) {
        this.instructionsList = instructionsList;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                ", recipe_id=" + recipe_id +
                "name='" + name + '\'' +
                ", cookName='" + cookName + '\'' +
                ", averageTime=" + averageTime +
                ", createdAt=" + createdAt +
                ", instructions='" + instructions + '\'' +
                ", mealType='" + mealType + '\'' +
                '}';
    }
}
