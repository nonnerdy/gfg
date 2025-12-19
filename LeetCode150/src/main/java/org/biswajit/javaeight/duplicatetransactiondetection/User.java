package org.biswajit.javaeight.duplicatetransactiondetection;

public class User {
    private String userName;
    private String transactionId;
    private int transactionAmount;



    public User(String userName, String transactionId, int transactionAmount) {
        this.userName = userName;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", transactionAmount=" + transactionAmount +
                '}';
    }


}
