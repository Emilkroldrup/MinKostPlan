package minkostplan.application.entity;

import java.time.LocalDateTime;

/**
 * Represents a recipe entity.
 */
public class Recipe {

    private String name;
    private String cookName;
    private Integer averageTime;
    private LocalDateTime createdAt;

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
     */
    public Recipe(String name, String cookName, Integer averageTime, LocalDateTime createdAt) {
        this.name = name;
        this.cookName = cookName;
        this.averageTime = averageTime;
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "{" +
            ", name='" + getName() + "'" +
            ", cookName='" + getCookName() + "'" +
            ", averageTime='" + getAverageTime() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }
}
