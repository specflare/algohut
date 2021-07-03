package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;

import java.util.HashMap;
import java.util.Map;

// Given an array of integers nums and an integer target, return indices of the two numbers
// such that they add up to target.
// https://leetcode.com/problems/two-sum/
public class TwoSum {
    // Two-pass hash-table solution
    public static int[] twoSum_v2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Single-pass hash table
    public static int[] twoSum_v3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Util.printArray(TwoSum.twoSum_v2(new int[]{2, 7, 11, 15}, 9), Integer.MAX_VALUE);
        Util.printArray(TwoSum.twoSum_v2(new int[]{3, 2, 4}, 9), Integer.MAX_VALUE);
        Util.printArray(TwoSum.twoSum_v2(new int[]{3, 3}, 9), Integer.MAX_VALUE);
    }
}
