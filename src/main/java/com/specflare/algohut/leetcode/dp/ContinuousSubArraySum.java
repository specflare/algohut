package com.specflare.algohut.leetcode.dp;

// Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two
// whose elements sum up to a multiple of k, or false otherwise.
// An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/continuous-subarray-sum/
public class ContinuousSubArraySum {

    // Brute-force solution, with O(N^2) extra space - NOT acceptable!
    public static boolean checkSubarraySum_bf(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        int[][] dp = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];

                if (dp[i][j] % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    // If we have 2 indices to whom we have the same modulo sum,
    // we can consider these indices as start and end, and return.
    // if there are two cumulative sums, a & b such that
    // (b - a) % k = 0
    // b%k - a%k = 0
    // b%k = a%k
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        m.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;

            if (m.containsKey(sum)) {
                if (i - m.get(sum) > 1) {
                    return true;
                }
            } else {
                m.put(sum, i);
            }
        }

        return false;
    }
}
