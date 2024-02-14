package com.specflare.algohut.leetcode.arrays;

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of
 * the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container,
 * such that the container contains the most water.
 */

// 11. Container With Most Water: (Medium)
// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(c.maxArea(new int[] {1,1}));
        System.out.println(c.maxArea(new int[] {4,3,2,1,4}));
        System.out.println(c.maxArea(new int[] {1,2,1}));
    }
}
