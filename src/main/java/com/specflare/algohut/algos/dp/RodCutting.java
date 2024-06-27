package com.specflare.algohut.algos.dp;

// https://www.techiedelight.com/rod-cutting/

/**
 * Given a rod of length n and a list of rod prices of length i, where 1 <= i <= n,
 * find the optimal way to cut the rod into smaller rods to maximize profit.
 */
public class RodCutting {
    static int getMaxAmountDriver(int rodLength, int[] prices) {
        int[] dp = new int[rodLength + 1];
        return getMaxAmount(rodLength, prices, dp);
    }

    static int getMaxAmount(int rodLength, int[] prices, int[] dp) {
        if (rodLength == 0) {
            return dp[0] = 0;
        }

        if (rodLength < 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[rodLength] != 0) {
            return dp[rodLength];
        }

        int maxSum = 0;
        for (int i = 1; i < prices.length; i++) {
            maxSum = Math.max(maxSum,
                    prices[i] + getMaxAmount(rodLength - i, prices, dp));
        }

        return dp[rodLength] = maxSum;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {0, 1, 5, 8, 9, 10, 17, 17 , 20};
        System.out.println(getMaxAmountDriver(4, prices));
    }
}
