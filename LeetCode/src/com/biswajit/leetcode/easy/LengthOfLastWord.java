package com.biswajit.leetcode.easy;

import java.util.Arrays;

/*
https://leetcode.com/problems/length-of-last-word/

 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
    public static int lengthOfLastWord(String s) {
        String[] strArr = s.trim().split(" ");
        return strArr[strArr.length - 1].length();
    }
}
