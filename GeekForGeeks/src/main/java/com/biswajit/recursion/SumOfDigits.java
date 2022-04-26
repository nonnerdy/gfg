package com.biswajit.recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(123456789));
        //System.out.println(5%10);
    }

    public static int sumOfDigits(int N){
        if(N==0){
            return 0;
        }
        else{
            return N%10+sumOfDigits(N/10);
        }

    }
}
