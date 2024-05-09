package minkostplan.application.entity;

import java.time.LocalDateTime;

public class Subscription {

    private Long subscriptionId;
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;

    public Subscription() {
    }

    public Subscription(Long subscriptionId, User user, LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.subscriptionId = subscriptionId;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getSubscriptionId() {
        return this.subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
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
            " subscriptionId='" + getSubscriptionId() + "'" +
            ", user='" + getUser() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
