package com.specflare.algohut.leetcode.dp;

// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and
// return its area.

import java.util.Stack;

// https://leetcode.com/problems/maximal-rectangle/
// https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
public class MaximumRectangleFromMatrix {
    public int maxRectangle(int A[][]) {
        return maxRectWithHist(A);
    }

    public int maxRectWithHist(int A[][]) {
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
    private static int maxHist(int row[]) {
        Stack<Integer> result = new Stack<>();
        int top_val;
        int max_area = 0;
        int area = 0;

        int i = 0;
        while (i < row.length) {
            if (result.empty() || row[result.peek()] <= row[i]) {
                result.push(i++);
            } else {
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;
                if (!result.empty()) {
                    area = top_val * (i - result.peek() - 1);
                }
                max_area = Math.max(area, max_area);
            }
        }

        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }

        return max_area;
    }
}
