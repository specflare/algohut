package com.specflare.algohut.leetcode.dp;

import com.specflare.algohut.Util;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be none)
 * of the characters without disturbing the remaining characters' relative positions.
 * (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It is guaranteed the answer fits on a 32-bit signed integer.
 */

// 115. Distinct Subsequences (Hard)
// https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }

        if (0 == t.length()) {
            return 1;
        }

        if (s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }

        int[][] memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                memo[i][j] = -1;
            }
        }

        int res = numDistinctSubseq(s, t, memo, s.length() - 1, t.length() - 1);
        Util.printMatrix(memo);
        return res;
    }


    public int numDistinctSubseq(String s, String t, int[][] memo, int i, int j) {
        if (i < j) {
            memo[i][j] = 0;
            return 0;
        }
        if (s.charAt(i) == t.charAt(j)) {
            if (0 == j) {
                memo[i][j] = 1;
                return 1;
            }

            memo[i][j] = numDistinctSubseq(s, t, memo, i - 1, j - 1)
                    + numDistinctSubseq(s, t, memo, i - 1, j);
            return memo[i][j];
        }
        memo[i][j] = numDistinctSubseq(s, t, memo, i - 1, j);
        return memo[i][j];
    }

    public int numDistinctDP(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }

        if (0 == t.length()) {
            return 1;
        }

        if (s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }

        return numDistinctSeqDP(s, t);
    }

    private int numDistinctSeqDP(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (i < j) {
                    // There is no way we can convert a shorter string into a longer one by deleting chars.
                    dp[i][j] = 0;
                    continue;
                }
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // all we can do is to discard S[i] and move on.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
//        System.out.println(String.format("S = %s, T = %s", s, t));
//        Util.printMatrix(dp);
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences ds = new DistinctSubsequences();
//        System.out.println(ds.numDistinct("", ""));
//        System.out.println(ds.numDistinct("i", ""));
//        System.out.println(ds.numDistinct("if", ""));
//        System.out.println(ds.numDistinct("if", "f"));
//        System.out.println(ds.numDistinct("rabbbit", "rabbbit"));
//        System.out.println(ds.numDistinct("rabbbit", "rabbit"));
        System.out.println(ds.numDistinct("BABABA", "BA"));

        System.out.println("\nNow the DP variant: ");
        System.out.println(ds.numDistinctDP("", ""));
        System.out.println(ds.numDistinctDP("i", ""));
        System.out.println(ds.numDistinctDP("if", ""));
        System.out.println(ds.numDistinctDP("if", "f"));
        System.out.println(ds.numDistinctDP("rabbbit", "rabbbit"));
        System.out.println(ds.numDistinctDP("rabbbit", "rabbit"));
        System.out.println(ds.numDistinctDP("BABABA", "BA"));
        System.out.println(ds.numDistinctDP("babgbag", "bag"));
    }
}
