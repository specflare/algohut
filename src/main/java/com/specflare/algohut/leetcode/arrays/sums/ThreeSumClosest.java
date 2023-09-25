package com.specflare.algohut.leetcode.arrays.sums;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */

// https://leetcode.com/problems/3sum-closest/
// 16. 3Sum Closest (Medium)
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];

                if (currSum == target) {
                    return currSum;
                }

                if (Math.abs(target - currSum) < Math.abs(target - bestSum)) {
                    bestSum = currSum;
                }

                if (currSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return bestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        System.out.println(tsc.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
        System.out.println(tsc.threeSumClosest(new int[] {0,0,0}, 1));
        System.out.println(tsc.threeSumClosest(new int[] {2,-3,4,-5,6,-7,8,-9,0}, 20));
        System.out.println(tsc.threeSumClosest(new int[] {-3,-2,-5,3,-4}, -1));
    }
}
