package org.biswajit.javaeight.paymentfailuredetection;

public class Payment {
    private String payment;
    private String paymentStatus;

    public Payment(String payment, String paymentStatus) {
        this.payment = payment;
        this.paymentStatus = paymentStatus;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment='" + payment + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
