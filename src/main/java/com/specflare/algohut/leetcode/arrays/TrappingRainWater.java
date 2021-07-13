package com.specflare.algohut.leetcode.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */

// 42. Trapping Rain Water: (Hard) - NOT COMPLETE - NOT WORKING YET !!!
// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        while (true) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < height.length; i++) {
                min = Math.min(min, height[i]);
                max = Math.max(max, height[i]);
            }

            if (0 == max) {
                break;
            }

            int left = 0;
            int right = height.length - 1;
            while (height[left++] == min);
            while (height[right--] == min);

            int count = 0;
            for (int i = left; i <= right; i++) {
                if (height[i] == min) {
                    count++;
                }
            }

            result += count * min;

            if (min > 0) {
                for (int i = 0; i < height.length; i++) {
                    height[i] -= min;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
