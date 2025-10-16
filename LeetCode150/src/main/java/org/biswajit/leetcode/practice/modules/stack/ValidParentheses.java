package org.biswajit.leetcode.practice.modules.stack;

import java.util.Stack;
//LC - 20
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }
    public static boolean isValid(String s) {

        Stack<Character> parentheses = new Stack<>();

        if(s.length() == 1)
            return false;

        for(char ch : s.toCharArray()){
            if(parentheses.isEmpty()){
                parentheses.push(ch);
                continue;
            }
            if(parentheses.peek() == '(' && ch == ')'){
                parentheses.pop();
            } else if (parentheses.peek() == '{' && ch == '}') {
                parentheses.pop();
            } else if (parentheses.peek() == '[' && ch == ']') {
                parentheses.pop();
            }
            else{
                parentheses.push(ch);
            }

        }
       return parentheses.isEmpty();

    }
}
