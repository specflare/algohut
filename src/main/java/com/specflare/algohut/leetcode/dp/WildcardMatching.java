package com.specflare.algohut.leetcode.dp;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 *  - '?' Matches any single character.
 *  - '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 */

// https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {
    public static boolean matches(String S, String P, int i, int j) {
        if (i == S.length()) {
            return j == P.length();
        }

        if (j == P.length()) {
            return false;
        }

        if (S.charAt(i) == P.charAt(j)) {
            return matches(S, P, i + 1, j + 1);
        }

        if (P.charAt(j) == '?') {
            return matches(S, P, i + 1, j + 1);
        }

        if (P.charAt(j) == '*') {
            if (j == P.length() - 1) { // P ends in '*'
                return true;
            }

            boolean valid = false;
            for (int skip = 0; skip < S.length() - i; skip++) {
                valid = valid || matches(S, P, i + skip, j + 1);
            }

            return valid;
        }

        return false;
    }

    public static boolean matches(String S, String P) {
        int m = S.length();
        int n = P.length();

        boolean[][] dp = new boolean[m + 1][n + 1]; // all false by default
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = (P.charAt(j - 1) == '*') && dp[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == P.charAt(j - 1) || P.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (P.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    public static boolean isMatch(String s, String p) {
        return matches(s, p, 0, 0);
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("abcjojcd", "a*jc?"));
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "*"));
//        System.out.println(isMatch("cb", "?a"));
//        System.out.println(isMatch("adceb", "*a*b"));
//        System.out.println(isMatch("acdcb", "a*c?b"));
//
//        // ---- iterative variant
//        System.out.println("\n2D DP iterative: ");
//        System.out.println(matches("abcjojcd", "a*jc?"));
//        System.out.println(matches("aa", "a"));
//        System.out.println(matches("aa", "*"));
//        System.out.println(matches("cb", "?a"));
//        System.out.println(matches("adceb", "*a*b"));
//        System.out.println(matches("acdcb", "a*c?b"));
//        System.out.println(matches("abcdefghijklmnopqr", "a*f??***************************r"));
        System.out.println(matches("aab", "c*a*b"));
    }
}
