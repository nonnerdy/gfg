package org.biswajit.javaeight.extractuniquecitiessafely;

public class UserProfile {
    private String user;
    private String address;

    public UserProfile(String user, String address) {
        this.user = user;
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "user='" + user + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
