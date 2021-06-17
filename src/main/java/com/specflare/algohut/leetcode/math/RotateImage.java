package com.specflare.algohut.leetcode.math;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */

// https://leetcode.com/problems/rotate-image/
public class RotateImage {
//    public static void rotate(int[][] matrix) {
//        int N = matrix.length;
//
//        for (int layer = 0; layer < N / 2; layer++) {
//            for (int j = layer; j < N - layer; j++ ) {
//                int tmp = matrix[layer][j];
//                matrix[][]
//            }
//        }
//    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }

            System.out.println();
        }
    }

    // uses tranpose + mirror left/right
    public static void rotate_v2(int[][] matrix) {
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

    public static void main(String[] args) {
        int[][] in1 = {{5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};

        System.out.println("Original matrix: ");
        printMatrix(in1);

        System.out.println("Rotated matrix: ");
        rotate_v2(in1);
        printMatrix(in1);
    }
}
