package org.biswajit.javaeight.aggregateusingreduce;

public class CustomerPurchaseDetails {
    private String customer;
    private int amount;

    public CustomerPurchaseDetails(String customer, int amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CustomerPurchaseDetails{" +
                "customer='" + customer + '\'' +
                ", amount=" + amount +
                '}';
    }
}
