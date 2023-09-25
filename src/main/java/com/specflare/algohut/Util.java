package com.specflare.algohut;

public class Util {
    public static void printArray(int[] arr, int n) {
        System.out.print("arr = [");
        for (int i = 0, size = Math.min(arr.length, n); i < size; i++) {
            System.out.print("\"" + arr[i] + "\"");
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printArray(String[] arr, int n) {
        System.out.print("arr = [");
        for (int i = 0, size = Math.min(arr.length, n); i < size; i++) {
            System.out.print("\"" + arr[i] + "\"");
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printMatrix(int[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
