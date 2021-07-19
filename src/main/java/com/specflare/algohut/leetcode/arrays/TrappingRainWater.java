package com.specflare.algohut.leetcode.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Another solution: Divide-et-impera:
 *  - find the tallest height, and split there. waterQty = waterLeft + waterRight.
 *  - repeat this process until the diff between left and right is 1, and return zero.
 */

// 42. Trapping Rain Water: (Hard) - NOT COMPLETE - NOT WORKING YET !!!
// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int qty = 0;
        while (true) {
            qty += countZeros(height);

            boolean nonZero = false;
            for (int i = 0; i < height.length; i++) {
                height[i] = Math.max(0, height[i] - 1);

                nonZero = nonZero || (height[i] > 0);
            }

            if (!nonZero) {
                break;
            }
        }

        return qty;
    }

    private int countZeros(int[] height) {
        int count = 0;

        int i = 0;
        int j = height.length - 1;
        while (height[i] == 0) i++;
        while (height[j] == 0) j--;

        while (i <= j) {
            if (height[i] == 0) {
                count++;
            }
            i++;
        }

        return count;
    }

    // O(n)
    public int trap_On(int[] height) {
        int n = height.length, max = 0, ans = 0;
        int[] maxL = new int[n], maxR = new int[n];

        for(int i = 0; i < n; i++){
            max = Math.max(max, height[i]);
            maxL[i] = max;
        }

        max = 0;
        for(int i = n - 1; i >= 0; i--){
            max = Math.max(max, height[i]);
            maxR[i] = max;
        }

        for(int i = 0; i < n; i++)
            ans += Math.min(maxL[i], maxR[i]) - height[i];

        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        System.out.println(trw.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trw.trap(new int[] {4,2,0,3,2,5}));
        System.out.println(trw.trap(new int[] {1}));
        System.out.println(trw.trap(new int[] {1, 0}));
        System.out.println(trw.trap(new int[] {1, 0, 1}));
    }
}
