package com.specflare.algohut.leetcode.dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return true if you can partition the array into two
 * subsets such that the sum of the elements in both subsets is equal or false otherwise.
 */
// 416. Partition Equal Subset Sum
// https://leetcode.com/problems/partition-equal-subset-sum/description/
public class PartitionEqualSubsetSum {
    Boolean[][] dp;
    private boolean helper(int[] nums, int k, int currSum, int targetSum) {
        if (dp[k][currSum] != null) {
            return dp[k][currSum];
        }

        if (k == 0) {
            if (targetSum == currSum) {
                dp[k][currSum] = true;
            }
        } else {
            dp[k][currSum] = helper(nums, k - 1, currSum + nums[k], targetSum) ||
                               helper(nums, k - 1, currSum, targetSum);
        }

        return dp[k][currSum];
    }

    public boolean canPartition_r(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int halfSum = sum / 2;
        dp = new Boolean[nums.length][sum + 1];
        return helper(nums, nums.length - 1, 0, halfSum);
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition_r(new int[] {1,5,11,5}));
        System.out.println(p.canPartition_r(new int[] {1,2,3,5}));
    }

    // iterative DP solution, 2 dimensions: nums[i] X targetSum
//    public boolean canPartition_it(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if (sum % 2 != 0) return false;
//        int halfSum = sum / 2;
//        boolean[][] dp = new boolean[nums.length + 1][halfSum + 1];
//        // dp[i][targetSum] = true if nums[0..i] can add up to targetSum exactly, false otherwise
//        // initial fillings
//        for (int i = 0; i <= nums.length; i++) {
//            for (int j = 0; j <= halfSum; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] = (j == nums[i]);
//                } else if (j < nums[i]) {
//                    dp[i][j] = false;
//                } else if (j >= nums[i]) {
//                    if (nums[i] == 0) {
//                        dp[i][j] = dp[i - 1][j];
//                    } else {
//                        // dp[i][j] = dp[i - 1][j - 1], daca targetSum-ul anterior + num[i] == targetSum-ul(
//                        if (j == )
//
//                    }
//                }
//            }
//        }
//
//        return dp[nums.length][halfSum];
//    }
}
