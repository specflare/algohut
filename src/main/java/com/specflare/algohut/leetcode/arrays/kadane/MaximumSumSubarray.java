package com.specflare.algohut.leetcode.arrays.kadane;

// https://leetcode.com/problems/maximum-subarray/
// 53. Maximum Subarray (Medium): Kadane's algorithm
public class MaximumSumSubarray {
    public int maxSubArray(int[] nums) {
        int current_sum = 0;
        int best_sum = Integer.MIN_VALUE;
        int best_start = 0;
        int best_end = 0;
        for (int i = 0; i < nums.length; i++) {
            current_sum += nums[i];

            if (best_sum < current_sum) {
                best_sum = current_sum;
                best_end = i;
            }

            if (current_sum < 0) {
                current_sum = 0;
                best_start = i;
            }
        }

        return best_sum;
    }

    public static void main(String[] args) {
        MaximumSumSubarray mss = new MaximumSumSubarray();
        System.out.println(mss.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
