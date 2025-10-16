package org.example.java.designpattern.creational.singleton;

public class SingletonExample{
    public static void main(String[] args) {
        Singleton logger1 = Singleton.getInstance();
        Singleton logger2 = Singleton.getInstance();

        logger1.log("Application started");
        logger2.log("User logged in");

        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));
    }
}
