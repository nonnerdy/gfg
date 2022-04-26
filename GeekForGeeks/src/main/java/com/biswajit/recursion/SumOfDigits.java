package com.biswajit.recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(123));
        //System.out.println(5%10);
    }

    public static int sumOfDigits(int N){
        if(N%10==N){
            return N;
        }
        else if(N%10==0){
            return 1;
        }
        else{
            return sumOfDigits(N/10);
        }

    }
}
