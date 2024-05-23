package minkostplan.application.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a recipe entity.
 */
public class Recipe {

    private String name;
    private String cookName;
    private Integer averageTime;
    private LocalDateTime createdAt;
    private String instructions; // Add instructions as a list of strings

    /**
     * Default constructor.
     */
    public Recipe() {
    }

    /**
     * Constructs a new Recipe with specified details.
     *
     * @param name the name of the recipe
     * @param cookName the name of the cook
     * @param averageTime the average time to prepare the recipe
     * @param createdAt the creation date and time of the recipe
     * @param instructions the list of instructions for the recipe
     */
    public Recipe(String name, String cookName, Integer averageTime, LocalDateTime createdAt, String instructions) {
        this.name = name;
        this.cookName = cookName;
        this.averageTime = averageTime;
        this.createdAt = createdAt;
        this.instructions = instructions;
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

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", cookName='" + getCookName() + "'" +
            ", averageTime='" + getAverageTime() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", instructions='" + getInstructions() + "'" +
            "}";
    }
}
