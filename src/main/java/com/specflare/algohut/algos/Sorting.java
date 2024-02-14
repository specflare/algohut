package com.specflare.algohut.algos;

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
                // swap arr[i] with arr[j], thus placing lower elements left of pivot.
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                i++;
            }
        }

        // i counts the number of elements lower than pivot
        // !!! we now place the pivot at its correct position !!!.
        // After the for loop ends, we will have between (left..i-1) all the elements lower than pivot
        // and between (i+1..right) all the elements greater than pivot.
        arr[i] ^= arr[right];
        arr[right] ^= arr[i];
        arr[i] ^= arr[right];
        return i;
    }

    // Merge Sort: Time: O(n*log(n)); Space O(n)
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

    // Insertion Sort: O(n^2)
    // Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
    // The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and
    // placed at the correct position in the sorted part.
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // we find the position for arr[i], between 0 and i-1
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Select Sort: O(n^2)
    // At every step, we select the minimum from the unsorted array, and place it into position
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                }
            }
        }
    }
}
