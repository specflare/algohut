package com.specflare.algohut.leetcode.math;

import com.specflare.algohut.Util;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */

// https://leetcode.com/problems/rotate-image/ (Medium)
// https://www.programcreek.com/2013/01/leetcode-rotate-image-java/
public class RotateImage {
    // uses transpose + mirror left/right
    public static void rotate90deg_transpose1stDiagonalThenFlipLeftRight(int[][] matrix) {
        int N = matrix.length;

        // First we transpose the matrix by the 1st diagonal
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // We mirror the matrix left/right
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j - 1];
                matrix[i][N - j - 1] = tmp;
            }
        }
    }

    public static void rotate90deg_transpose2ndDiagonalThenFlipUpDown(int[][] matrix) {
        int N = matrix.length;

        // First we transpose the matrix by the 2nd diagonal
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // We mirror the matrix up / down
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[N - i - 1][j];
                matrix[N - i - 1][j] = tmp;
            }
        }
    }

    public static void rotate90deg_layerByLayer(int[][] matrix) {
        int N = matrix.length;
        // for a 3x3 matrix row is always 0, and col is 0 1.
        for (int row = 0; row < N / 2; row++) {
            for (int col = row; col < N - row - 1; col++) {
                // we start from upper left corner.
                int tmp = matrix[row][col];

                // upper left := lower left
                matrix[row][col] = matrix[N - col - 1][row];

                // lower left := lower right
                matrix[N - col - 1][row] = matrix[N - row - 1][N - col - 1];

                // lower right := upper right
                matrix[N - row - 1][N - col - 1] = matrix[col][N - row -1];

                // close the loop
                matrix[col][N - row -1] = tmp;
            }
        }
    }

    private static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = (i + 1) * (j + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] in1 = generateMatrix(5);

        System.out.println("Original matrix: ");
        Util.printMatrix(in1);

        System.out.println("Rotated matrix 90deg - by 1st diagonal: ");
        rotate90deg_transpose1stDiagonalThenFlipLeftRight(in1);
        Util.printMatrix(in1);

        System.out.println("Rotated matrix 90 deg - by 2nd diagonal: ");
        int[][] in2 = generateMatrix(5);
        rotate90deg_transpose2ndDiagonalThenFlipUpDown(in2);
        Util.printMatrix(in1);

        System.out.println("Rotated Matrix - Liviu's version in layers:");
        int[][] in3 = generateMatrix(5);
        rotate90deg_layerByLayer(in3);
        Util.printMatrix(in3);
    }
}
