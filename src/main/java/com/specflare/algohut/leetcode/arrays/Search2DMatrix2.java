package com.specflare.algohut.leetcode.arrays;

/**
 * Write an efficient algorithm that searches for a value target in
 * an m x n integer matrix matrix. This matrix has the following properties:
 *  Integers in each row are sorted in ascending from left to right.
 *  Integers in each column are sorted in ascending from top to bottom.
 */
// 240. Search a 2D Matrix II (Medium)
// https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // pornim de la i maxim, adica i == m, si j minim, adica j = 0.
        // asadar, i poate doar sa scada, iar j poate doar sa creasca.

        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (target < matrix[i][j]) {
                i--;
            } else {
                j++;
            }
        }

        return false;
    }
}
