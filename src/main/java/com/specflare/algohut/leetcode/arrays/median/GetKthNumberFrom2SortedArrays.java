package com.specflare.algohut.leetcode.arrays.median;

import com.specflare.algohut.Util;

/**
 * If k is the middle element, this implementation also solves finds the median of 2 sorted arrays.
 */

// https://fizzbuzzed.com/top-interview-questions-2/
// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class GetKthNumberFrom2SortedArrays {
    /**
     * Time complexity: (O(log(m + n)))
     * Space complexity: O(1)
     */
    private static int getKth(int[] arr1, int[] arr2, int i, int j, int k) {
        if (i == arr1.length) {
            return arr2[j + k];
        }

        if (j == arr2.length) {
            return arr1[i + k];
        }

        if (0 == k) {
            return Math.min(arr1[i], arr2[j]);
        }

        int mid1 = Math.min(arr1.length - i, (k + 1) / 2);
        int mid2 = Math.min(arr2.length - j, (k + 1) / 2);

        int a = arr1[i + mid1 - 1];
        int b = arr2[j + mid2 - 1];

        System.out.println(String.format("i = %d, j = %d, k = %d, mid1=%d, mid2=%d, a=%d, b=%d", i, j, k, mid1, mid2, a, b));

        if (a < b) {
            // discard left of 'a'
            return getKth(arr1, arr2, i + mid1, j, k - mid1);
        }

        // discard left of 'b'
        return getKth(arr1, arr2, i, j + mid2, k - mid2);
    }

    private static float findMedianOf2SortedArrays(int[] arr1, int[] arr2) {
        if (0 == arr1.length || 0 == arr2.length) {
            return 0.f;
        }

        int totalCount = arr1.length + arr2.length;
        System.out.println("The 2 arrays: ");
        Util.printArray(arr1, arr1.length);
        Util.printArray(arr2, arr2.length);
        System.out.println("Total count: " + totalCount);

        if (0 == (totalCount % 2)) {
            int first  = getKth(arr1, arr2, 0, 0, totalCount / 2 - 1);
            System.out.println("---");
            int second = getKth(arr1, arr2, 0, 0, totalCount / 2);
            System.out.println("Even number of elems. Median is the average of elems at pos: "
                    + (totalCount / 2 - 1) + " and " + (totalCount / 2));
            return (first + second) / 2.f;
        }

        // odd number of elements, just return the middle one
        System.out.println("(Odd number of elements) Median is at position: " + (totalCount / 2));
        return getKth(arr1, arr2, 0, 0, totalCount / 2);
    }

    public static void main(String[] args) {
        System.out.println(findMedianOf2SortedArrays(
                new int[] {-5, 3, 6, 12, 15},
                new int[] {-12, -10, -6, -3, 4, 10}));

        System.out.println("-----------------------------");
        System.out.println(findMedianOf2SortedArrays(
                        new int[] {2, 3, 5, 8},
                        new int[] {10, 12, 14, 16, 18, 20}));
    }
}
