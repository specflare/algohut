package com.github.petascalr.algohut.algos;

public class Sorting {
    // Quick Sort: O(n*log(n))
    public static void quickSort(int[] arr) {
        if (arr.length > 1) {
            quickSort_r(arr, 0, arr.length - 1);
        }
    }

    private static void quickSort_r(int[] arr, int left, int right) {
        if (left < right) {
            int p = partitionLemuto(arr, left, right);
            quickSort_r(arr, left, p - 1);
            quickSort_r(arr, p + 1, right);
        }
    }

    /**
     * The key process in quickSort is partition().
     * Target of partitions is, given an array and an element x of array as pivot, put x at its correct position
     * in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements
     * (greater than x) after x. All this should be done in linear time.
     */
    private static int partitionLemuto(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j <= right; j++) {
            if (arr[j] < pivot) {
                // swap arr[i] with arr[j]
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                i++;
            }
        }

        // i counts the number of elements lower than pivot
        // we now place the pivot at its correct position.
        // After the for loop ends, we will have between (left..i-1) all the elements lower than pivot
        // and between (i+1..right) all the elements greater than pivot.
        arr[i] ^= arr[right];
        arr[right] ^= arr[i];
        arr[i] ^= arr[right];
        return i;
    }

    // Merge Sort: O(n*log(n))
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            mergeSort_r(arr, 0, arr.length - 1);
        }
    }

    private static void mergeSort_r(int[] arr, int left, int right) {
        if (left < right) {
            int mij = (left + right) / 2;
            mergeSort_r(arr, left, mij);
            mergeSort_r(arr, mij + 1, right);

            // we now have 2 sorted arrays: arr1 = (left .. mij), arr2 = (mij+1 .. right)
            // and we need to merge them together.
            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int left, int right) {
        int mij = (left + right) / 2;
        int n1 = mij - left + 1;
        int n2 = right - mij;

        // create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays L[] and R[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mij + 1 + j];

        // Merge the temp arrays back into arr[left..right]
        int k = left; // Initial index of merged subarray
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[], if there are any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[], if there are any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
