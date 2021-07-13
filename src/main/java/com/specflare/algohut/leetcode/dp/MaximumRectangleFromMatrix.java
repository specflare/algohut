package com.specflare.algohut.leetcode.dp;

// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and
// return its area.

/**
 * Solution 1 for maxAreaUnderHistogram: using Divide and Conquer:
 * The idea is to find the minimum value in the given array. Once we have index of the minimum value,
 *  the max area is maximum of following three values.
 *      a) Maximum area in left side of minimum value (Not including the min value)
 *      b) Maximum area in right side of minimum value (Not including the min value)
 *      c) Number of bars multiplied by minimum value.
 */

import java.util.Stack;

// 85. Maximal Rectangle (Hard)
// https://leetcode.com/problems/maximal-rectangle/
// https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
public class MaximumRectangleFromMatrix {
    public int maxRectangle(int[][] A) {
        return maxRectWithHist(A);
    }

    public int maxRectWithHist(int[][] A) {
        int result = maxHist(A[0]);

        // Update max area, considering each row as a histogram.
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    A[i][j] += A[i - 1][j];
                }
            }

            result = Math.max(result, maxHist(A[i]));
        }

        return result;
    }
    // returns the maximum area of a rectangle under a histogram kept in row.
    private static int maxHist(int[] row) {
        Stack<Integer> stack = new Stack<>();
        int top_val;
        int max_area = 0;
        int area = 0;

        int i = 0;
        while (i < row.length) {
            if (stack.empty() || row[stack.peek()] <= row[i]) {
                // keep monotonic stack (increasing)
                stack.push(i++);
            } else {
                top_val = row[stack.peek()];
                stack.pop();
                area = top_val * i;
                if (!stack.empty()) {
                    area = top_val * (i - stack.peek() - 1);
                }
                max_area = Math.max(area, max_area);
            }
        }

        // clean up the stack
        while (!stack.empty()) {
            top_val = row[stack.peek()];
            stack.pop();
            area = top_val * i;
            if (!stack.empty())
                area = top_val * (i - stack.peek() - 1);

            max_area = Math.max(area, max_area);
        }

        return max_area;
    }

    public static void main(String[] args) {
        MaximumRectangleFromMatrix mr = new MaximumRectangleFromMatrix();
//        System.out.println(mr.maxRectangle(new int[][] {
//                {1, 0, 1, 0, 0},
//                {1, 0, 1, 1, 1},
//                {1, 1, 1, 1, 1},
//                {1, 0, 0, 1, 0}
//        }));

        System.out.println(maxHist(new int[]{2, 0, 2, 1, 1}));
    }
}
