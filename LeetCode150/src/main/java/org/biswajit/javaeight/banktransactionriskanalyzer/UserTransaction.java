package org.biswajit.javaeight.banktransactionriskanalyzer;

public class UserTransaction {
    private String user;
    private int amount;
    private boolean transactionStatus;

    public UserTransaction(String user, int amount, boolean transactionStatus) {
        this.user = user;
        this.amount = amount;
        this.transactionStatus = transactionStatus;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "UserTransaction{" +
                "user='" + user + '\'' +
                ", amount=" + amount +
                ", transactionStatus=" + transactionStatus +
                '}';
    }
}
