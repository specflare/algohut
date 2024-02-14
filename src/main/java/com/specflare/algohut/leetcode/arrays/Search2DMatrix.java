package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Playground;
import com.specflare.algohut.Util;

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
