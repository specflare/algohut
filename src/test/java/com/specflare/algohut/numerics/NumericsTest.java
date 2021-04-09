package com.specflare.algohut.numerics;

import java.util.Random;

public class NumericsTest {
    private Random r = new Random();

    public float[][] getRandomMatrix(int m, int n) {
        float[][] res = new float[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 100 * r.nextFloat() / Float.MAX_VALUE; // values between 0..100
            }
        }

        return res;
    }

    public float[] getRandomVector(int len) {
        float[] res = new float[len];

        for (int i = 0; i < len; i++) {
            res[i] = 100 * r.nextFloat() / Float.MAX_VALUE;
        }

        return res;
    }

    public void printMatrix(float[][] matr) {
        int m = matr.length;
        int n = matr[0].length;

        System.out.format("Matrix [%d X %d]", m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matr[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void printVector(float[] vect) {
        for (int i = 0; i < vect.length; i++) {
            System.out.print(vect[i]+ " ");
        }

        System.out.println();
    }
}
