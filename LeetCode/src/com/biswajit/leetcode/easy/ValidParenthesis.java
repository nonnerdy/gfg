package com.biswajit.leetcode.easy;


import java.util.PriorityQueue;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
/*
Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
    public static boolean isValid(String s){
        Stack<String> parenthesis = new Stack<>();
        if(s == null){
            return false;
        }
        for(int i = 0; i<s.length();i++){
            String tmp = Character.toString(s.charAt(i));
            if(parenthesis.empty())
                parenthesis.push(tmp);
            else if((parenthesis.peek().equals("(") && tmp.equals(")")) ||
                    (parenthesis.peek().equals("[") && tmp.equals("]"))  ||
                            (parenthesis.peek().equals("{") && tmp.equals("}")))
                parenthesis.pop();
            else
                parenthesis.push(tmp);

        }

        return parenthesis.size() == 0;
    }
}
