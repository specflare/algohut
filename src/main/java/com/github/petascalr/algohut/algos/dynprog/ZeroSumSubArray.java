package com.github.petascalr.algohut.algos.dynprog;

// Given an array of integer numbers, tell if there exists a sub-array whose sum is 0.
public class ZeroSumSubArray {
    public static boolean zeroSumSubArray(int[] arr) {
        if (0 == arr.length) {
            return true;
        }

        return zeroSumSubArr_r(arr, 0, 0);
    }

    private static boolean zeroSumSubArr_r(int[] arr, int currSum, int i) {
        if (i > 0 && 0 == currSum) {
            return true;
        }

        if (i >= arr.length) {
            return 0 == currSum;
        }

        if (0 == arr[i]) {
            return true;
        }

        return zeroSumSubArr_r(arr, currSum + arr[i], i + 1) ||
                zeroSumSubArr_r(arr, currSum, i + 1);
    }

    // Iterative approach: Bottom-up approach
    // we have 2 dimensions: currSum & currItem
    private static boolean zeroSumSubArr_iterative(int[] arr) {
        int size = arr.length;
        boolean[][] zeroSum = new boolean[size][size];

        for (int currItem = 0; currItem < size; currItem++) {
            for (int currSum = 0; currSum < size; currSum++) {
                // if currItem is zero, the accumulated sum so far does not matter, we just return true
                if (0 == currItem) {
                    zeroSum[currSum][0] = true;
                }

                if (0 == currSum && currItem > 0) {
                    zeroSum[currSum][currItem] = true;
                }
            }
        }
        return true;
    }
}
