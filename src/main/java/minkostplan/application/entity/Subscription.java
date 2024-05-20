package minkostplan.application.entity;

import java.time.LocalDateTime;

/**
 * Represents a subscription entity.
 */
public class Subscription {

    private Users user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;

    /**
     * Default constructor.
     */
    public Subscription() {
    }

    /**
     * Constructs a new Subscription with specified details.
     *
     * @param user the user
     * @param startDate the start date of the subscription
     * @param endDate the end date of the subscription
     * @param status the status of the subscription
     */
    public Subscription(Users user, LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
            ", user='" + getUser() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
