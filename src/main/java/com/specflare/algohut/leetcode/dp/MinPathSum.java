package com.specflare.algohut.leetcode.dp;

import com.specflare.algohut.Util;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
// https://leetcode.com/problems/minimum-path-sum/
// 64. Minimum Path Sum (Medium)
public class MinPathSum {
    int[] dx = new int[]{0, 1};
    int[] dy = new int[]{1, 0};

    public int minPathSum(int[][] grid) {
        return getMinCostDP_TopDown(grid);
        // return getMinCostDP_BottomUp(grid);
    }

    private int getMinCostDP_TopDown(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int cost = helper(grid, 0, 0, dp);
        Util.printMatrix(dp);
        return cost;
    }

    public int helper(int[][] matr, int row, int col, int[][] dp) {
        if (row == matr.length - 1 && col == matr[0].length - 1) {
            dp[row][col] = matr[row][col];
            return matr[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < dx.length; i++) {
            int newCol = col + dx[i];
            int newRow = row + dy[i];

            if (newCol < 0 || newRow < 0 || newRow >= matr.length || newCol >= matr[0].length) {
                continue;
            }

            cost = Math.min(cost, matr[row][col] + helper(matr, newRow, newCol, dp));
        }

        dp[row][col] = cost;
        return cost;
    }

    public int getMinCostDP_BottomUp(int[][] matr) {
        int[][] dp = new int[matr.length][matr[0].length];

        dp[0][0] = matr[0][0];
        for (int i = 1; i < matr.length; i++) {
            dp[i][0] = dp[i - 1][0] + matr[i][0];
        }

        for (int j = 1; j < matr[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + matr[0][j];
        }

        for (int i = 1; i < matr.length; i++) {
            for (int j = 1; j < matr[0].length; j++) {
                dp[i][j] = matr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        Util.printMatrix(dp);
        return dp[matr.length - 1][matr[0].length - 1];
    }

    public static void main(String[] args) {
        MinPathSum mps = new MinPathSum();
        System.out.println(mps.minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));

        System.out.println(mps.minPathSum(new int[][]{
                {1,3,4,4,7},
                {1,5,7,2,1},
                {1,2,1,1,5}
        }));

        System.out.println(mps.minPathSum(new int[][]{
            {1,2,3},
            {4,5,6}
        }));
    }
}
