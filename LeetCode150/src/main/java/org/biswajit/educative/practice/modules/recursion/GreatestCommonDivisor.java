package org.biswajit.educative.practice.modules.recursion;

import java.util.Set;
import java.util.SortedSet;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(42,54));

    }

    public static int gcd(int num1, int num2){
        if(num2 == 0 )
            return num1;
        else
            return gcd(num2, num1 % num2);
    }
    /*
    gcd(36,54)
    |gcd(36, 36 % 54) = gcd(36,54)
    gcd(54,36)
    |gcd(36, 54 %36) = gcd(36,18)
    gcd(36,18)
    |gcd(18, 36 % 18)= gcd(18,0)
    gcd(18,0)
    |
    return 18
     */
}
