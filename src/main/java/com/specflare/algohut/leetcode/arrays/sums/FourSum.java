package com.specflare.algohut.leetcode.arrays.sums;

import java.util.*;

/**
 * Given an array nums of n integers, return an array of all the unique
 *  quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *      - 0 <= a, b, c, d < n
 *      - a, b, c, and d are distinct.
 *      - nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * You may return the answer in any order.
 */

// https://leetcode.com/problems/4sum/
// 18. 4Sum (Medium)
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (null == nums || nums.length < 4) {
            return List.of();
        }

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int newTarget = target - nums[i] - nums[j];

                for (int k = j + 1, l = nums.length - 1; k < l;) {
                    int sum2 = nums[k] + nums[l];
                    if (sum2 == newTarget) {
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (sum2 < newTarget) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return new LinkedList<>(result);
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        System.out.println(fs.fourSum(new int[] {1,0,-1,0,-2,2}, 0));
        System.out.println(fs.fourSum(new int[] {2,2,2,2,2}, 8));
        System.out.println(fs.fourSum(new int[] {-5,-4,-3,-2,-1,0,1,2,3,4,5}, 0));
    }
}
