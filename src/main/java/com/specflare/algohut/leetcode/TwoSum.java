package com.specflare.algohut.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given an array of integers nums and an integer target, return indices of the two numbers
// such that they add up to target.
// https://leetcode.com/problems/two-sum/
public class TwoSum {
    // THis solution does not work if the 'nums' vector contains duplicates!!!
    public static int[] twoSum(int[] nums, int target) {
        int[] numsOrig = nums.clone();
        Arrays.sort(nums);
        int left = 0, right = 0;
        for (int i = 0, j = nums.length - 1; i < j;) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                left = nums[i];
                right = nums[j];
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[] {indexOf(numsOrig, left), indexOf(numsOrig, right)};
    }

    private static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

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
}
