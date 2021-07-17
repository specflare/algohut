package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;

import java.util.Arrays;

/**
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 Find the maximum profit you can achieve. You may complete at most k transactions.
 Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

// 123. Best Time to Buy and Sell Stock IV
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class BuyAndSellStockKTransactions {
    public int maxProfit(int k, int[] prices) {
        int[][] memo = new int[k + 1][prices.length + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int result = buyAndSell_recursive(prices, 0, -1, k, memo);
        // Util.printMatrix(memo);
        return result;
    }

    /**
     * we have the following options
     * 1. Do nothing, just increment i
     * 2. Buy at i-th position, and decrement k
     * 3. Sell at i-th position and take profit (if we previously bought)
     */

    // Recursive solution with memoization (Top-down approach)
    private int buyAndSell_recursive(int[] prices, int i, int lastBuyIndex, int k, int[][] memo) {
        if (k < 0 || i == prices.length) {
            memo[k][i] = 0;
            return memo[k][i];
        }

//        if (memo[k][i] != -1) {
//            return memo[k][i];
//        }

        // do nothing, just move on.
        int profitDoNothing = buyAndSell_recursive(prices, i + 1, lastBuyIndex, k, memo);

        // check if we can buy
        int profitBuy = 0;
        int profitSell = 0;
        if (lastBuyIndex == -1) {
            if (i < prices.length - 1 && k > 0) {
                profitBuy = buyAndSell_recursive(prices, i + 1, i, k - 1, memo);
            }
        } else {
            // we can also sell now
            if (prices[i] > prices[lastBuyIndex]) {
                profitSell = prices[i] - prices[lastBuyIndex];
                profitSell += buyAndSell_recursive(prices, i + 1, -1, k, memo);
            }
        }

        int maxProfit = Math.max(profitDoNothing, Math.max(profitBuy, profitSell));
        memo[k][i] = maxProfit;
        return memo[k][i];
    }

    public static void main(String[] args) {
        BuyAndSellStockKTransactions bsk = new BuyAndSellStockKTransactions();
        System.out.println(bsk.maxProfit(2, new int[] {2, 4, 1})); // 2
        System.out.println(bsk.maxProfit(2, new int[] {3, 2, 6, 5, 0, 3})); // 7
        System.out.println(bsk.maxProfit(2, new int[] {3,3,5,0,0,3,1,4})); // 6
    }
}
