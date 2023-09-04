package com.specflare.algohut.leetcode.dp;

/**
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Solution: The idea of the algorithm is to construct an auxiliary size matrix dp[][]
 *  in which each entry dp[i][j] represents the size of the square sub-matrix with
 *  all 1s including M[i][j] where M[i][j] is the rightmost and bottom-most entry in sub-matrix.
 */

// 221. Maximal Square (Medium): Solution OK.
// https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }

        return maxsqlen * maxsqlen;
    }
}
