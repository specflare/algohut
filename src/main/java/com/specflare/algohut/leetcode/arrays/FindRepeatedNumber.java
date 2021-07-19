package com.specflare.algohut.leetcode.arrays;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Solution: use fast/slow pointers to detect the loop (the duplicate number).
 * Algorithm name: Floyd's Tortoise & Hare (Cycle detection)
 *
 * Attention: we need to return the point where the loop begins,
 *      not the point where the fast/slow pointers meet for the first time !!!
 */

// 287. Find the Duplicate Number (Medium)
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

    public int findDup2(int[] nums) {
        int N = nums.length - 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum - N * (N + 1) / 2;
    }

    public static void main(String[] args) {
        FindRepeatedNumber frn = new FindRepeatedNumber();
        System.out.println(frn.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(frn.findDup2(new int[]{1,3,4,2,2}));

        System.out.println(frn.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(frn.findDup2(new int[]{3,1,3,4,2}));

        System.out.println(frn.findDuplicate(new int[]{1,1}));
        System.out.println(frn.findDup2(new int[]{1,1}));

        System.out.println(frn.findDuplicate(new int[]{1,1,2}));
        System.out.println(frn.findDup2(new int[]{1,1,2}));
    }
}
