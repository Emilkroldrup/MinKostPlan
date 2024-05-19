package minkostplan.application.entity;

import java.time.LocalDateTime;

public class Users {

    private String username;
    private String email;
    private String passwordHash;
    private LocalDateTime createdAt;


    public Users() {
    }

    public Users(String username, String email, String passwordHash, LocalDateTime createdAt) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "{" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", passwordHash='" + getPasswordHash() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }
}

