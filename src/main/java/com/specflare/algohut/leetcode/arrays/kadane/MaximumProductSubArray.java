package com.specflare.algohut.leetcode.arrays.kadane;

/**
 * Given an integer array nums, find a contiguous non-empty sub-array within the array that has the
 * largest product, and return the product.
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * A sub-array is a contiguous subsequence of the array.
 */

// 152. Maximum Product Sub-array (Medium)
// https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int currMax = 0;
        int currMin = 0;
        int maxSoFar = 0;

        // we need to keep the minium product because nums[i] can be negative,
        // and the product of 2 negative numbers turns into a positive number.
        for (int i = 0; i < nums.length; i++) {
            int oldMax = currMax;
            currMax = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * oldMax, nums[i] * currMin));
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumProductSubArray mps = new MaximumProductSubArray();
        System.out.println(mps.maxProduct(new int[] {2, 3, -2, 4}));
        System.out.println(mps.maxProduct(new int[] {2, 3, -2, 2, 4}));
        System.out.println(mps.maxProduct(new int[] {-1, 0, -2}));
        System.out.println(mps.maxProduct(new int[] {1,2,-3,4,5,-6,7,3,-9}));
        System.out.println(mps.maxProduct(new int[] {0,1,0,2,0,3,0,4,0,5}));

        System.out.println(mps.maxProduct(new int[] {-2, 3, -4}));
        System.out.println(mps.maxProduct(new int[] { -6, 4, -5, 8, -10, 0, 8 }));
    }
}
