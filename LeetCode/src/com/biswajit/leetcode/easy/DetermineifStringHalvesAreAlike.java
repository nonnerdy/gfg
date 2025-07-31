package com.biswajit.leetcode.easy;

/*
https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
 */
public class DetermineifStringHalvesAreAlike {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
    }

    public static boolean halvesAreAlike(String s) {
        String a = s.toLowerCase().substring(0,s.length()/2);
        String b = s.toLowerCase().substring((s.length()/2),s.length());
        int leftLength = 0;
        int rightLength = 0;
        System.out.println("a -> "+a+" b->"+b);
        for(int i = 0 ; i<a.length() ; i++){
            if(a.charAt(i)=='a' || a.charAt(i) == 'e' || a.charAt(i) == 'i' || a.charAt(i) == 'o' || a.charAt(i) == 'u'){
                leftLength++;
            }
        }
        for(int i = 0 ; i<b.length() ; i++){
            if(b.charAt(i)=='a' || b.charAt(i) == 'e' || b.charAt(i) == 'i' || b.charAt(i) == 'o' || b.charAt(i) == 'u'){
                rightLength++;
            }
        }

        return leftLength == rightLength;
    }
}
