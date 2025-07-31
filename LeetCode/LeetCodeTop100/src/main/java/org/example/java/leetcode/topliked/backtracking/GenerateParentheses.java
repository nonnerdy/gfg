package org.example.java.leetcode.topliked.backtracking;

/*
22
https://leetcode.com/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 */

import java.util.*;


public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses sol = new GenerateParentheses();
        System.out.println(sol.generateParenthesis(3));
        // Expected: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, int openCount, int closeCount,
                           StringBuilder current, List<String> result) {
        // Base case: built 2n characters
        if (openCount == n && closeCount == n) {
            result.add(current.toString());
            return;
        }

        // Try adding '('
        if (openCount < n) {
            current.append('(');
            backtrack(n, openCount + 1, closeCount, current, result);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }

        // Try adding ')'
        if (closeCount < openCount) {
            current.append(')');
            backtrack(n, openCount, closeCount + 1, current, result);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }
    }
}
