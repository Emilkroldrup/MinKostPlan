package minkostplan.application.entity;

import java.time.LocalDateTime;

public class Recipe {

    private String name;
    private String cookName;
    private Integer averageTime;
    private LocalDateTime createdAt;

    // Constructors
    public Recipe() {
    }

    public Recipe(String name, String cookName, Integer averageTime, LocalDateTime createdAt) {
        this.name = name;
        this.cookName = cookName;
        this.averageTime = averageTime;
        this.createdAt = createdAt;
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
