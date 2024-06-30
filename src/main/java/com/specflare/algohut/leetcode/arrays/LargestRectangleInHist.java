package com.specflare.algohut.leetcode.arrays;

import java.util.Stack;

// 84. Largest Rectangle in Histogram (Hard)
// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHist {
    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea_bruteForce(heights);
    }

    // accepted solution, with a stack
//    public int largestRectangleArea_stack(int[] heights) {
//        // keep a stack of heights, in increasing order.
//        Stack<Integer> st = new Stack<>();
//
//        for (int i = 0; i < heights.length; i++) {
//            if (st.isEmpty() || heights[i] >= st.peek()) {
//                st.push(heights[i]);
//            }
//
//            int removeCount = 0;
//            while (heights[i] < st.peek()) {
//                st.pop();
//                removeCount--;
//            }
//        }
//    }

    // brute-force solution, time limit exceeded!
    public int largestRectangleArea_bruteForce(int[] heights) {

        // we consider each bar to be the smallest in the current area, and we move left and right from it.
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;

            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }

            while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }

            int currArea = (right - left + 1) * heights[i];
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        LargestRectangleInHist lrih = new LargestRectangleInHist();

        // prints 10
        System.out.println(lrih.largestRectangleArea(new int[] {2,1,5,6,2,3}));

        // prints 4
        System.out.println(lrih.largestRectangleArea(new int[] {2,4}));
    }
}
