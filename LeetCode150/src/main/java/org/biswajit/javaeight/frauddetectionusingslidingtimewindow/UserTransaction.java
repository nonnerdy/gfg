package org.biswajit.javaeight.frauddetectionusingslidingtimewindow;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class UserTransaction {
    private String user;
    private LocalTime time;
    private int amount;

    public UserTransaction(String user, LocalTime time, int amount) {
        this.user = user;
        this.time = time;
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UserTransaction{" +
                "user='" + user + '\'' +
                ", time=" + time +
                ", amount=" + amount +
                '}';
    }


}
