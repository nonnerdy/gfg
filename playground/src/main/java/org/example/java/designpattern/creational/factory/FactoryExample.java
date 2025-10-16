package org.example.java.designpattern.creational.factory;

import static org.example.java.designpattern.creational.factory.TransactionMethod.*;

public class FactoryExample {
    public static void main(String[] args) {
        Payment payment1 = PaymentFactory.getPayment(UPI);
        payment1.pay(350);
        Payment payment2 = PaymentFactory.getPayment(CREDITCARD);
        payment2.pay(15000);
        Payment payment3 = PaymentFactory.getPayment(PAYPAL);
        payment3.pay(450000);
    }
}
