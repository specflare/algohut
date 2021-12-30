package com.specflare.algohut.leetcode;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

// 22. Generate Parentheses (Medium)
// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        List<String> result = new LinkedList<>();
        helper("", 2 * n, 0, result);
        return result;
    }

    private void helper(String s, int n, int sum, List<String> result) {
        if (0 == n) {
            if (0 == sum) {
                result.add(s);
            }
        } else {
            if (sum <= n) { // we only go deeper if we can close these parentheses.
                helper(s + "(", n - 1, sum + 1, result);
                if (sum > 0) {
                    helper(s + ")", n - 1, sum - 1, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(4));
    }
}
