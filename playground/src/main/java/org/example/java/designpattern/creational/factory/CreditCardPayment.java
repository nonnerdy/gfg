package org.example.java.designpattern.creational.factory;

public class CreditCardPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}
