package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;

/**
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 * Solution: for each number x, make arr[x] negative. then return the first positive elem.
 */

// 41. First Missing Positive (Hard)
// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {

    // partition vector in 2: first the negative numbers, then the positive numbers.
    private int segregate(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                int aux = Math.abs(nums[i]);
                if (aux == 0) {
                    aux++;
                }
                nums[i] = nums[j];
                nums[j] = aux;
                j++;
            }
        }
        return j; //starting with j-th position we only have positive numbers.
    }

    public int firstMissingPositive(int[] nums) {
        int positiveStart = segregate(nums);
        Util.printArray(nums, nums.length);
        for (int i = positiveStart; i < nums.length; i++) {
            int x = Math.abs(nums[i]) - 1;
            if (x < nums.length && nums[x] > 0) {
                nums[x] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        System.out.println(fmp.firstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(fmp.firstMissingPositive(new int[] {3,4,-1,1}));
        System.out.println(fmp.firstMissingPositive(new int[] {7,8,9,11,12}));
        System.out.println(fmp.firstMissingPositive(new int[] {1, 2, -5, 0, 4}));
        System.out.println(fmp.firstMissingPositive(new int[] {-3, -2, -1}));
        System.out.println(fmp.firstMissingPositive(new int[] {0}));
        System.out.println(fmp.firstMissingPositive(new int[] {-1}));
        System.out.println(fmp.firstMissingPositive(new int[] {1}));
    }
}
