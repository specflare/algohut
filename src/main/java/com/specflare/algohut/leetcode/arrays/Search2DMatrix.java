package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;

/**
 * You are given an m x n integer matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 */

// 74. Search a 2D Matrix (Medium)
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int left = 0;
        int right = numRows * numCols - 1;
        Util.printMatrix(matrix);
        System.out.printf("numRows = %d, numCols = %d, target = %d\n", numRows, numCols, target);

        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / numCols;
            int j = mid % numCols;

            System.out.printf("left = %d, right = %d, mid = %d, i = %d, j = %d\n", left, right, mid, i, j);

            if (matrix[i][j] == target) {
                return true;
            }

            if (target < matrix[i][j]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix p = new Search2DMatrix();
        System.out.println(p.searchMatrix(new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}}, 3));
    }
}
