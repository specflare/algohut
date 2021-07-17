package com.specflare.algohut.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioning2MinimumCut {
    public int minCut(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        int res = helper(s, 0, s.length() - 1, memo);
        return res;
    }

    private int helper(String s, int left, int right, Map<Integer, Integer> memo) {
        int memoKey = left * s.length() + right;

        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        if (left >= right || isPalindrome(s, left, right)) {
            memo.putIfAbsent(memoKey, 0);
            return 0;
        }

        // decide where do we cut?
        int minTotal = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPalindrome(s, left, i)) {
                minTotal = Math.min(minTotal, 1 + helper(s, i + 1, right, memo));
            }
        }

        memo.putIfAbsent(memoKey, minTotal);
        return minTotal;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning2MinimumCut pp = new PalindromePartitioning2MinimumCut();
        System.out.println(pp.minCut("abracadabra"));
        System.out.println(pp.minCut("aerisirea"));
        System.out.println(pp.minCut("aab"));
        System.out.println(pp.minCut("a"));
        System.out.println(pp.minCut("ab"));
        System.out.println(pp.minCut("abbc"));

        // best split: [c, ababa, bcb, c]
        System.out.println(pp.minCut("cabababcbc"));
        System.out.println(pp.minCut("aaabaa"));
    }
}
