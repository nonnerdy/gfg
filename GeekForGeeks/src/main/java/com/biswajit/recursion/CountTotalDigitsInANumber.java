package com.biswajit.recursion;

public class CountTotalDigitsInANumber {
    public static void main(String[] args) {
        System.out.println(countDigits(987609890));
    }
    public static int countDigits(int n){
        if(n==0){
            return 0;
        }
        else{
            return 1+countDigits(n/10);
        }
    }
}
