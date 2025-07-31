package com.biswajit.leetcode.easy;

public class ReformatPhoneNumber {
    public static void main(String[] args) {
        System.out.println(reformatPhoneNumber("123-9"));
    }
    public static String reformatPhoneNumber(String number){
        String refactoredNumber = number.replace(" ", "").replace("-", "");
        if(refactoredNumber.length() <= 3){
            return refactoredNumber;
        }
        else if(refactoredNumber.length() == 4){
            return  refactoredNumber.substring(0, 2) + "-" + refactoredNumber.substring(2, 4);
        }


        return null;
    }
}
