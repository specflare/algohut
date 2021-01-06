package com.github.petascalr.algohut.algos.combi;
import java.util.function.*;

public class Permutations {
    // Heap's algorithm for permutations generation
    static void genPermHeapRec(int[] arr, int n, Consumer<int[]> c) {
        if (0 == n) {
            c.accept(arr);
        } else {
            genPermRec(arr, n - 1, c);
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
                genPermRec(arr, n - 1, c);
            }
        }
    }

    static void genPermRec(int[] arr, int k, Consumer<int[]> c) {
        if (k == arr.length - 1) {
            c.accept(arr);
        } else {
            for (int i = k; i < arr.length; i++) {
                arr[i] = i;
                genPermRec(arr, k + 1, c);
            }
        }
    }

    static void genPermIter(int[] arr, Consumer<int[]> c) {

    }
}