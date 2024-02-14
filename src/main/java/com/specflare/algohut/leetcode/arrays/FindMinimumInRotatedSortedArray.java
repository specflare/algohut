package com.specflare.algohut.leetcode.arrays;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// 153. Find Minimum in Rotated Sorted Array (Medium)
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int minVal = nums[left];
        while (left < right) {
            minVal = Math.min(nums[left], nums[right]);

            if (nums[left] < nums[right]) {
                // array is not rotated, we already have the minimum value;
                break;
            }

            int mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return minVal;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray p = new FindMinimumInRotatedSortedArray();
        System.out.println(p.findMin(new int[] {3,4,5,1,2}));
        System.out.println(p.findMin(new int[] {3,4,5,1,2}));
        System.out.println(p.findMin(new int[] {11,13,15,17}));
    }
}
