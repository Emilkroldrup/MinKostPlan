package minkostplan.application.entity;

import java.time.LocalDateTime;

/**
 * Represents a user entity.
 */
public class Users {

    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private int weight;
    private String gender;
    private String goal;
    private String email;
    private String passwordHash;
    private LocalDateTime createdAt;
    private String activityLevel;

    /**
     * Default constructor.
     */
    public Users() {
    }

    /**
     * Constructs a new Users with specified details.
     *
     * @param username the username of the user
     * @param email the email of the user
     * @param passwordHash the password hash of the user
     * @param createdAt the creation date and time of the user
     */
    public Users(String firstName, String lastName, int age, int height, int weight, String gender, String goal, String email, String passwordHash, LocalDateTime createdAt, String activityLevel) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.height=height;
        this.weight=weight;
        this.gender=gender;
        this.goal=goal;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
        this.activityLevel = activityLevel;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height=height;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight=weight;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender=gender;
    }

    public String getGoal() {
        return this.goal;
    }

    public void setGoal(String goal) {
        this.goal=goal;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getActivityLevel() {
        return this.activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel=activityLevel;
    }

    @Override
    public String toString() {
        return "{" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", age='" + getAge() + "'" +
            ", height='" + getAge() + "'" +
            ", weight='" + getWeight() + "'" +
            ", gender='" + getGender() + "'" +
            ", goal='" + getGoal() + "'" +
            ", email='" + getEmail() + "'" +
            ", passwordHash='" + getPasswordHash() + "'" +
            ", activityLevel='" + getActivityLevel() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }
}

