package com.specflare.algohut.leetcode.arrays;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */

// 287. Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number/
public class FindRepeatedNumber {
    // Uses Cycle detection mechanism, like in a linked list to detect if we have cycles or not
    // also called: Floyd's Tortoise and Hare (Cycle Detection)
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = slow;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // or fast, since they are equal.
    }

    public static void main(String[] args) {
        FindRepeatedNumber frn = new FindRepeatedNumber();
        System.out.println(frn.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(frn.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(frn.findDuplicate(new int[]{1,1}));
        System.out.println(frn.findDuplicate(new int[]{1,1,2}));
    }
}
