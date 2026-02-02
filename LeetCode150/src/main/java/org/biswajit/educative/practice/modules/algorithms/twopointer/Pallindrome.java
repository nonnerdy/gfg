package org.biswajit.educative.practice.modules.algorithms.twopointer;

public class Pallindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPallindrome(s));
    }
    public static boolean isPallindrome(String s){
        String s1 = s.replaceAll("[^a-zA-Z]","").toLowerCase();
        int initialPointer = 0;
        int endPointer = s1.length() - 1;
        while(initialPointer < endPointer){
            if(s1.charAt(initialPointer) == s1.charAt(endPointer)){
                initialPointer++;
                endPointer--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
