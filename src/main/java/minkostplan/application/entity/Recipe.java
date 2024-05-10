package minkostplan.application.entity;

import java.time.LocalDateTime;

public class Recipe {

    private Long recipeId;
    private String name;
    private String cookName;
    private Integer averageTime;
    private LocalDateTime createdAt;

    // Constructors
    public Recipe() {
    }

    public Recipe(Long recipeId, String name, String cookName, Integer averageTime, LocalDateTime createdAt) {
        this.recipeId = recipeId;
        this.name = name;
        this.cookName = cookName;
        this.averageTime = averageTime;
        this.createdAt = createdAt;
    }

    // Getters and Setters

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

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
}
