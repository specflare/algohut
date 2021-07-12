package com.specflare.algohut.leetcode.arrays.sums;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */

// https://leetcode.com/problems/3sum/
// 15. 3Sum (Medium)
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length < 3) {
            return List.of();
        }

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int X = nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum2 = nums[j] + nums[k];
                if (sum2 == -X) {
                    result.add(List.of(X, nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum2 < -X) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return new LinkedList<>(result);
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[] {-1, 0}));
        System.out.println(ts.threeSum(new int[] {0}));
        System.out.println(ts.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(ts.threeSum(new int[] {-5,-4,-3,-2,-1,0,1,2,3,4,5}));
    }
}
