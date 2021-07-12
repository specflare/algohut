package com.specflare.algohut.leetcode.arrays;

/**
 * You are given an integer array nums. The absolute sum of a subarray
 * [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
 * Return the maximum absolute sum of any (possibly empty) subarray of nums.
 *
 * Solution: use Kadane's  algorithm to find the maximum sum and the minimum sum
 * then return max of their abs values.
 */
// 1749. Maximum Absolute Sum of Any Subarray
// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
public class MaxAbsSumSubArray {
    public int maxAbsoluteSum(int[] nums) {
        int total_min_sum = 0;
        int best_min_sum = Integer.MAX_VALUE;

        int total_max_sum = 0;
        int best_max_sum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            total_max_sum = Math.max(0, total_max_sum + nums[i]);
            total_min_sum = Math.min(0, total_min_sum + nums[i]);

            best_max_sum = Math.max(best_max_sum, total_max_sum);
            best_min_sum = Math.min(best_min_sum, total_min_sum);
        }

        return Math.max(Math.abs(best_min_sum), Math.abs(best_max_sum));
    }

    public static void main(String[] args) {
        MaxAbsSumSubArray m = new MaxAbsSumSubArray();
        // System.out.println(m.maxAbsoluteSum(new int[] {1,-3,2,3,-4}));
        System.out.println(m.maxAbsoluteSum(new int[] {2,-5,1,-4,3,-2}));
    }
}
