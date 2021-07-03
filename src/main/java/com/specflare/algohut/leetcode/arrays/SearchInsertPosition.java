package com.specflare.algohut.leetcode.arrays;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */

// 35. Search Insert Position
// https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (0 == nums.length) {
            return 0;
        }

        return getIndexRec(nums, target, 0, nums.length - 1);
    }

    private static int getIndexRec(int[] nums, int target, int left, int right) {
        int middle = (left + right) / 2;

        if (nums[middle] == target) {
            return middle;
        }

        if (left >= right) {
            return target < nums[middle]
                    ? Math.max(0, left)
                    : Math.min(nums.length, right + 1);
        }

        if (target < nums[middle]) {
            return getIndexRec(nums, target, left, middle - 1);
        }

        return getIndexRec(nums, target, middle + 1, right);
    }
}
