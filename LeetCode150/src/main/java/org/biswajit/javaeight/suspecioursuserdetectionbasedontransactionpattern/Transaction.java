package org.biswajit.javaeight.suspecioursuserdetectionbasedontransactionpattern;

public class Transaction {
    private String transactionId;
    private Long transactionAmount;
    private Long transactionTime;

    public Transaction(String transactionId, Long transactionAmount, Long transactionTime) {
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.transactionTime = transactionTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Long getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Long transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionTime=" + transactionTime +
                '}';
    }
}
