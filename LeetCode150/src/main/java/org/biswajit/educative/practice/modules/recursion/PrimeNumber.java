package org.biswajit.educative.practice.modules.recursion;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(7,9));
    }

    public static boolean isPrime(int num,int i){
        if(num < 2){
            return false;
        }
        else if (i == 1){
            return true;
        }
        else if(num % i == 0){
            return false;
        }
        else
            return isPrime(num, i - 1);

    }
}
