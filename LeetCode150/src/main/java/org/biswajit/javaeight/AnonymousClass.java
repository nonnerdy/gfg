package org.biswajit.javaeight;

public class AnonymousClass {
    public void m1(){
        System.out.println("Normal method/function");
    }


    public static void main(String[] args) {
      FunctionalInt res = () -> System.out.println("this is anonymous");
      res.m1();
    }
}
