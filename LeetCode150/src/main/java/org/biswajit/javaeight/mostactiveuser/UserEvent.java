package org.biswajit.javaeight.mostactiveuser;

public class UserEvent {
    private String userId;
    private String userEvent;

    public UserEvent(String userId, String userEvent) {
        this.userId = userId;
        this.userEvent = userEvent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEvent() {
        return userEvent;
    }

    public void setUserEvent(String userEvent) {
        this.userEvent = userEvent;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "userId='" + userId + '\'' +
                ", userEvent='" + userEvent + '\'' +
                '}';
    }
}
