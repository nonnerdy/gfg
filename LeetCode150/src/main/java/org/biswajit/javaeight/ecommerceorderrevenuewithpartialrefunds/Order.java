package org.biswajit.javaeight.ecommerceorderrevenuewithpartialrefunds;

import java.util.List;

public class Order {
    private String order;
    private String customer;
    private List<Payment> payments;
    private List<Refund> refunds;

    public Order(String order, String customer, List<Payment> payments, List<Refund> refunds) {
        this.order = order;
        this.customer = customer;
        this.payments = payments;
        this.refunds = refunds;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refund> refunds) {
        this.refunds = refunds;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order='" + order + '\'' +
                ", customer='" + customer + '\'' +
                ", payments=" + payments +
                ", refunds=" + refunds +
                '}';
    }
}
