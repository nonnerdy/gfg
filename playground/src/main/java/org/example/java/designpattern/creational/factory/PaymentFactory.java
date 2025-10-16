package org.example.java.designpattern.creational.factory;

public class PaymentFactory {
    public static Payment getPayment(TransactionMethod type) {
        return switch (type) {
            case CREDITCARD -> new CreditCardPayment();
            case UPI -> new UPIPayment();
            case PAYPAL -> new PaypalPayment();
        };
    }
}
