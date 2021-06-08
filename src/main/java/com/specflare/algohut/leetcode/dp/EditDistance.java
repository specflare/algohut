package com.specflare.algohut.leetcode.dp;

// https://leetcode.com/problems/edit-distance/
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }

        if (word2.length() == 0) {
            return word1.length();
        }

        return minEditDist_recursive(word1, word2, 0, 0);
    }

    // minimum edit distance to convert W1 into W2.
    public static int minEditDist_recursive(String W1, String W2, int i, int j) {
        if (i == W1.length()) {
            return W2.length() - j;
        }

        if (j == W2.length()) {
            return W1.length() - i;
        }

        if (W1.charAt(i) == W2.charAt(j)) {
            return minEditDist_recursive(W1, W2, i + 1, j + 1);
        }

        int del_distance = 1 + minEditDist_recursive(W1, W2, i + 1, j);
        int replace_distance = 1 + minEditDist_recursive(W1, W2, i + 1, j + 1);
        int insert_distance = 1 + minEditDist_recursive(W1, W2, i, j + 1);

        return Math.min(del_distance, Math.min(replace_distance, insert_distance));
    }

    public static int minEditDistanceDP(String W1, String W2) {
        int m = W1.length();
        int n = W2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (W1.charAt(i - 1) == W2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("a", ""));
        System.out.println(minDistance("a", "a"));
        System.out.println(minDistance("a", "b"));
        System.out.println(minDistance("aa", "b"));
        System.out.println(minDistance("abcdefgh", "12345678"));

        System.out.println("\n");
        System.out.println(minEditDistanceDP("horse", "ros"));
        System.out.println(minEditDistanceDP("intention", "execution"));
        System.out.println(minEditDistanceDP("a", ""));
        System.out.println(minEditDistanceDP("a", "a"));
        System.out.println(minEditDistanceDP("a", "b"));
        System.out.println(minEditDistanceDP("aa", "b"));
        System.out.println(minEditDistanceDP("abcdefgh", "12345678"));
    }
}
