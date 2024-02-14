package com.specflare.algohut.leetcode;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * A palindrome string is a string that reads the same backward as forward.
 */

// 131. Palindrome Partitioning (Medium)
// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        Stack<String> split = new Stack<>();

        helper(s, 0, result, split);
        return result;
    }

    private void helper(String s, int curr, List<List<String>> result, Stack<String> split) {
        if (curr >= s.length()) {
            result.add(new LinkedList<>(split));
            return;
        }

        for (int i = curr; i < s.length(); i++) {
            if (isPalindrome(s, curr, i)) {
                String subs = s.substring(curr, i + 1);
                split.add(subs);
                helper(s, i + 1, result, split);
                split.pop();
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("abba"));
        System.out.println(pp.partition("aab"));
        System.out.println(pp.partition("cabababcbc"));
    }
}
