package org.biswajit.leetcode.practice.modules.twopointers;

//https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t){
        if(s.isEmpty()) return true;
        if(s.equals(t)) return true;

        int j = 0;
        for(int i = 0 ; i < t.length() ; i++){
            if(t.charAt(i) == s.charAt(j)){
                j++;
                if(j == s.length()) return true;
            }
        }
        return false;
    }
}
