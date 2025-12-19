package org.biswajit.javaeight.customerpurchaseconsistency;

public class Customer {
    private String name;
    private Months month;

    public Customer(String name, Months month) {
        this.name = name;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Months getMonth() {
        return month;
    }

    public void setMonth(Months month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", month=" + month +
                '}';
    }
}
