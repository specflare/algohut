package com.specflare.algohut.leetcode.dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return true if you can partition the array into two
 * subsets such that the sum of the elements in both subsets is equal or false otherwise.
 */

// 416. Partition Equal Subset Sum
// https://leetcode.com/problems/partition-equal-subset-sum/description/
public class PartitionEqualSubsetSum {

    private boolean helper(int nums[], int k, int targetSum, Boolean[][] dp) {
        if (dp[k][targetSum] == null) {
            // we need to compute it
            if (k == 0) {
                dp[k][targetSum] = (targetSum == 0);
                return dp[k][targetSum];
            }

            boolean res1 = helper(nums, k - 1, targetSum - nums[k], dp);
            boolean res2 = helper(nums, k - 1, targetSum, dp);

            dp[k][targetSum] = (res1 || res2);
        }

        return dp[k][targetSum];
    }

    public boolean canPartition_r(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int halfSum = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][halfSum + 1];
        return helper(nums, nums.length - 1, halfSum, dp);
    }

    // iterative DP solution, 2 dimensions: nums[i] X targetSum
    public boolean canPartition_it(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int halfSum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][halfSum + 1];
        // dp[i][targetSum] = true if nums[0..i] can add up to targetSum exactly, false otherwise
        // initial fillings
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= halfSum; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (j == nums[i]);
                } else if (j < nums[i]) {
                    dp[i][j] = false;
                } else if (j >= nums[i]) {
                    if (nums[i] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // dp[i][j] = dp[i - 1][j - 1], daca targetSum-ul anterior + num[i] == targetSum-ul(
                        if (j == )

                    }
                }
            }
        }

        return dp[nums.length][halfSum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition_it(new int[] {1,5,11,5}));
        System.out.println(p.canPartition_it(new int[] {1,2,3,5}));
    }
}
