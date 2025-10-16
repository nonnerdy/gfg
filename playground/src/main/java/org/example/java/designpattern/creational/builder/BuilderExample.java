package org.example.java.designpattern.creational.builder;

public class BuilderExample {
    public static void main(String[] args) {
        Pizza pizza1 =new Pizza.Builder("Large").addBacon().addCheese().addPepperoni().build();
        Pizza pizza2 = new Pizza.Builder("Small").addBacon().addPepperoni().build();

        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}
