package com.biswajit.recursion;

public class NthFibonacciUsingRecursion {
    public static void main(String[] args) {
        System.out.println(fibonacciRecursion(200));
    }

    public static int fibonacciRecursion(int n){
        System.out.print(n);
            if(n==1){
                return 1;
            }
            if(n==2){
                return 1;
            }
            return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);
    }
}
