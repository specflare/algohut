package com.specflare.algohut.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 Find the maximum profit you can achieve. You may complete at most k transactions.
 Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

// 123. Best Time to Buy and Sell Stock IV
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class BuyAndSellStockKTransactions {
    public int maxProfit(int k, int[] prices) {
        Map<Integer, Integer> memo = new HashMap<>();
        // Util.printMatrix(memo);
        return buyAndSell_recursive(prices, 0, -1, k, memo);
    }

    /**
     * we have the following options
     * 1. Do nothing, just increment i
     * 2. Buy at i-th position, and decrement k
     * 3. Sell at i-th position and take profit (if we previously bought)
     */

    // Recursive solution with memoization (Top-down approach)
    private int buyAndSell_recursive(int[] prices, int i, int lastBuyIndex, int k, Map<Integer, Integer> memo) {
        int key = (i << 20) | (lastBuyIndex << 10) | k;
        if (k < 0 || i == prices.length) {
            memo.putIfAbsent(key, 0);
            return 0;
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

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
        memo.putIfAbsent(key, maxProfit);
        return maxProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStockKTransactions bsk = new BuyAndSellStockKTransactions();
        System.out.println(bsk.maxProfit(2, new int[] {2, 4, 1})); // 2
        System.out.println(bsk.maxProfit(2, new int[] {3, 2, 6, 5, 0, 3})); // 7
        System.out.println(bsk.maxProfit(2, new int[] {3,3,5,0,0,3,1,4})); // 6
    }
}
