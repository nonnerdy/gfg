package com.biswajit.recursion;

/*
You are given a number n. You need to find the digital root of n.
DigitalRoot of a number is the recursive sum of its digits until we get a single digit number.

Example 1:

Input:
n = 1
Output:  1
Explanation: Digital root of 1 is 1

Example 2:
Input:
n = 99999
Output: 9
Explanation: Sum of digits of 99999 is 45
which is not a single digit number, hence
sum of digit of 45 is 9 which is a single
digit number.
 */
public class DigitalRoot {
    public static void main(String[] args) {
        System.out.println(digitalRoot(9876));
    }
    public static int digitalRoot(int n){

        int tmp = n;
        int sum = 0;
        while(tmp!=0){
            int val = tmp%10;
            sum+=val;
            tmp = tmp/10;
        }
        if(sum/10!=0){
            return digitalRoot(sum);
        }

        return sum;
    }
}
