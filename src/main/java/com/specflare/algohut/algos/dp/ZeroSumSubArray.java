package com.specflare.algohut.algos.dp;

/**
 * Given an array of positive and negative numbers, the task is to find if
 * there is a subarray (of size at least one) with 0 sum.
 */

// WRONG SOLUTION: the subarray must be contiguous (it is not a sub-sequence).
public class ZeroSumSubArray {
    public static boolean zeroSumSubArray(int[] arr) {
        if (0 == arr.length) {
            return true;
        }

        return zeroSumSubArr_r(arr, 0, 0);
    }

    private static boolean zeroSumSubArr_r(int[] arr, int currSum, int i) {
        if (i > 0 && 0 == currSum) {
            return true;
        }

        if (i >= arr.length) {
            return 0 == currSum;
        }

        if (0 == arr[i]) {
            return true;
        }

        return zeroSumSubArr_r(arr, currSum + arr[i], i + 1) ||
                zeroSumSubArr_r(arr, currSum, i + 1);
    }

    // Iterative approach: Bottom-up approach
    // we have 2 dimensions: currSum & currItem
    private static boolean zeroSumSubArr_iterative(int[] arr) {
        boolean[][] dp = new boolean[arr.length][arr.length];

        for (int currItem = 0; currItem < arr.length; currItem++) {
            for (int currSum = 0; currSum < arr.length; currSum++) {
                // if currItem is zero, the accumulated sum so far does not matter, we just return true
                if (0 == currItem) {
                    dp[currSum][0] = true;
                }

                if (0 == currSum && currItem > 0) {
                    dp[currSum][currItem] = true;
                }
            }
        }
        return true;
    }

    // recursive solution, brute force
    public static boolean zeroSumSubArr2(int[] arr, int i, int j, int currSum) {
        if (i > j) {
            return false;
        }

        if (i == j && j == arr.length) {
            return currSum == 0;
        }

        // subArray must be at least 1 element
        if (0 == currSum) {
            return true;
        }

        boolean case1 = zeroSumSubArr2(arr, i + 1, j, currSum - arr[i]);
        boolean case2 = zeroSumSubArr2(arr, i, j + 1, currSum + arr[j]);
        return case1 || case2;
    }

    public static void main(String[] args) {
        System.out.println(zeroSumSubArr2(new int[]{1, 4, -2, -2, 5, -4, 3}, 0, 0, 0));
        System.out.println(zeroSumSubArr2(new int[]{1, 4, -2, -5, 5, -4, 3}, 0, 0, 0));
    }
}
