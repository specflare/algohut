package com.specflare.algohut.algos.combinatorics;

import com.specflare.algohut.Util;

import java.util.Arrays;

public class Permutations {
    public static void permutations_backtracking(int[] stack, int K, int N) { // WORKING
        if (K == N) {
            Util.printArray(stack, K);
            return;
        }

        for (int i = 1; i <= N; i++) {
            stack[K] = i;
            if (isValid(stack, K)) {
                permutations_backtracking(stack, K + 1, N);
            }
            stack[K] = 0;
        }
    }

    private static boolean isValid(int[] stack, int K) {
        for (int i = 0; i < K; i++) {
            if (stack[i] == stack[K]) {
                return false;
            }
        }

        return true;
    }

    // ---------------------------------------
    // Heap algorithm
    // Heap's algorithm for permutations generation (Wikipedia)
    public static void genPermHeapRec(int[] arr, int n) {
        if (0 == n) {
            System.out.println(Arrays.toString(arr));
        } else {
            genPermHeapRec(arr, n - 1);
            for (int i = 0; i < n - 1; ++i) {
                if (0 == (i % 2)) {
                    swap(arr, i, n - 1);
                } else {
                    swap(arr, 0, n - 1);
                }
                genPermHeapRec(arr, n - 1);
            }
        }
    }

    // Generating permutation using Heap Algorithm (GfG - easier to understand)
    public static void heapPermutation(int[] arr, int N) {
        if (N == 1) {
            System.out.println(Arrays.toString(arr));
        }

        for (int i = 0; i < N; i++) {
            heapPermutation(arr, N - 1);

            int temp;
            if (N % 2 == 1) {
                temp = arr[0];
                arr[0] = arr[N - 1];
            } else {
                temp = arr[i];
                arr[i] = arr[N - 1];
            }
            arr[N - 1] = temp;
        }
    }

    // Generating permutations recursively
    // Let's introduce the idea of the state. It will consist of two things:
    // the current permutation and the index of the currently processed element.
    private static void permute(int[] arr, int k) {
        if (k == arr.length) {
            Util.printArray(arr, k);
            return;
        }

        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            permute(arr, k + 1);
            swap(arr, i, k);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        permutations_backtracking(new int[3], 0, 3);

        System.out.println("Permute recursively: ");
        // permute recursively
        int[] arr = new int[]{1, 2, 3};
        permute(arr, 1);
    }
}
