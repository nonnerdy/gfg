package org.biswajit.javaeight.ecommerceorderrevenuewithpartialrefunds;

public class Payment {
    private int payment;

    public Payment(int payment) {
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment=" + payment +
                '}';
    }
}
