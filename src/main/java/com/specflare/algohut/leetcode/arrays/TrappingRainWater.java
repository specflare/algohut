package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;

import java.util.Stack;

/**
 * leetcode #42. Trapping Rain Water: (Hard)
 *  https://leetcode.com/problems/trapping-rain-water/
 *  https://www.geeksforgeeks.org/trapping-rain-water/
 *
 * Problem statement:
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *  compute how much water it can trap after raining.
 *
 *  *** Solution 1: O(N)
 *     * for each height[i], it can trap this much water:
 *     *  trap[i] = min(maxLeft[i], maxRight[i]) - height[i]
 *     *  Total trapped water: SumOf(trap[i])
 *
 *  *** Solution 2: O(N), using a stack:
 *  We can use a stack to track the bars that are bounded by the higher left and right bars.
 *  This can be done using only one iteration.
 *  For this we will keep pushing elements in stack, until an element with higher value than the stack top is found.
 *  This denotes that there is a chance of storing position on the left side of the current element with the
 *  current bar being an end.
 *  So remove the smaller element on left and find the left bar (which is the current top of stack) and the
 *  amount of water stored by the left end bar and the current bar being the right end.
 *  Continue this till the stack is not empty or a higher value element is found.
 */


public class TrappingRainWater {

    // brute force, not accepted!!
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

    // Solution 1, Time: O(N), Space: O(N) - Accepted!
    public int trapWater_MaxLeftRight(int[] height) {
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

    // Solution 2, with a stack. Time: O(N), Space(N)
    public int trapWater_Stack(int[] heights) {
        System.out.println(" --- new run ---");
        Util.printArray(heights, heights.length);
        if (heights.length < 3) {
            return 0;
        }

        Stack<Integer> st = new Stack<>(); // stack contains the indices of elements of decreasing heights

        int trappedWater = 0;
        for (int i = 0; i < heights.length; i++) {
            if (st.empty() || heights[i] <= heights[st.peek()]) {
                st.push(i); //push the index, not the value!
                continue;
            }

            System.out.printf("found a greater value, i=%d, heights[%d]=%d, st = " + st + "\n", i, i, heights[i]);

            int top = st.pop();
            System.out.println("removed: " + top);
            while (!st.empty() && heights[st.peek()] <= heights[i]) {
                int currTop = st.pop();
                int width = i - currTop - 1;
                int currTrap = (heights[currTop] - heights[top]) * width;
                trappedWater += currTrap;
                System.out.printf("removed: %d, width=%d, currTrap=%d, trapped=%d\n", currTop, width, currTrap, trappedWater);
            }
            st.push(i);
            System.out.println("st = " + st);
        }

        return trappedWater;
    }

    public static void main(String[] args) {
//        TrappingRainWater trw = new TrappingRainWater();
//        System.out.println(trw.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(trw.trap(new int[] {4,2,0,3,2,5}));
//        System.out.println(trw.trap(new int[] {1}));
//        System.out.println(trw.trap(new int[] {1, 0}));
//        System.out.println(trw.trap(new int[] {1, 0, 1}));
//
//        System.out.println("---");
//        // System.out.println(trw.trapWaterWithStack(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(trw.trapWaterWithStack(new int[] {4,2,0,3,2,5}));
////        System.out.println(trw.trapWaterWithStack(new int[] {1}));
////        System.out.println(trw.trapWaterWithStack(new int[] {1, 0}));
////        System.out.println(trw.trapWaterWithStack(new int[] {1, 0, 1}));
    }
}
