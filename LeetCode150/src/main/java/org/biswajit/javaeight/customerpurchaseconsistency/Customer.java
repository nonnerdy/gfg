package org.biswajit.javaeight.customerpurchaseconsistency;

import java.time.YearMonth;

public class Customer {
    private String name;
    private YearMonth month;

    public Customer(String name, YearMonth month) {
        this.name = name;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YearMonth getMonth() {
        return month;
    }

    public void setMonth(YearMonth month) {
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
