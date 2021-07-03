package com.specflare.algohut.algos.combinatorics;
import java.util.Arrays;

public class PermutationsHeapAlgorithm {
    // Heap's algorithm for permutations generation (Wikipedia)
    public static void genPermHeapRec(int[] arr, int n) {
        if (0 == n) {
            System.out.println(Arrays.toString(arr));
        } else {
            genPermHeapRec(arr, n - 1);
            for (int i = 0; i < n - 1; ++i) {
                if (0 == (i % 2)) {
                    // swap a[i] with a[n-1]
                    arr[i] ^= arr[ n - 1];
                    arr[ n - 1] ^= arr[i];
                    arr[i] ^= arr[ n - 1];
                } else {
                    // swap a[0] with a[n-1]
                    arr[0] ^= arr[ n - 1];
                    arr[ n - 1] ^= arr[0];
                    arr[0] ^= arr[ n - 1];
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

    public static void main(String[] args) {
        // genPermHeapRec(new int[]{1, 2, 3}, 3);
        heapPermutation(new int[]{1, 2, 3}, 3);
    }
}