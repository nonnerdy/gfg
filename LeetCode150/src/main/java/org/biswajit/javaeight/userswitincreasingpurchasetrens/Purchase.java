package org.biswajit.javaeight.userswitincreasingpurchasetrens;

import java.time.LocalDate;

public class Purchase {
    private String userId;
    private LocalDate date;
    private int amount;

    public Purchase(String userId, LocalDate date, int amount) {
        this.userId = userId;
        this.date = date;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "userId='" + userId + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
