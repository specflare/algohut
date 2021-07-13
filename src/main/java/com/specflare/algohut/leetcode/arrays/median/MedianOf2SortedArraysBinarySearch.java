package com.specflare.algohut.leetcode.arrays.median;

import com.specflare.algohut.Util;

public class MedianOf2SortedArraysBinarySearch {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            // we only do binary search on the smaller array
            return findMedianSortedArrays(B, A);
        }

        int sizeA = A.length;
        int sizeB = B.length;
        int leftA = 0;
        int rightA = sizeA;
        System.out.print("A = "); Util.printArray(A, A.length);
        System.out.print("B = "); Util.printArray(B, B.length);
        System.out.println(String.format("sizeA = %d, sizeB = %d", sizeA, sizeB));
        while (leftA <= rightA) {
            // Partitions of both the array. For odd number of elems, the median will be on the left, hence the +1.
            int midA = (leftA + rightA) / 2;
            int midB = (sizeA + sizeB + 1) / 2 - midA; // This equation is the key to this algorithm !!!
            System.out.println(String.format("leftA = %d, midA = %d, rightA = %d, midB = %d", leftA, midA, rightA, midB));

            // If there are no elements left on the left side after partition
            int maxLeftA = midA == 0 ? Integer.MIN_VALUE : A[midA - 1];

            // If there are no elements left on the right side after partition
            int minRightA = midA == sizeA ? Integer.MAX_VALUE : A[midA];

            // Similarly for B
            int maxLeftB = midB == 0 ? Integer.MIN_VALUE : B[midB - 1];
            int minRightB = midB == sizeB ? Integer.MAX_VALUE : B[midB];

            // Check if we have found the match
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // Check if the combined array is of even/odd length
                if ((sizeA + sizeB) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            }
            else if (maxLeftA > minRightB) {
                // If we are too far on the right, we need to go to left side
                rightA = midA - 1; // discard the right half
            } else {
                // If we are too far on the left, we need to go to right side
                leftA = midA + 1;
            }
        }

        // If we reach here, it means the arrays are not sorted
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        MedianOf2SortedArraysBinarySearch mbs = new MedianOf2SortedArraysBinarySearch();
        System.out.println(mbs.findMedianSortedArrays(new int[] {4, 7, 11, 15, 19, 22}, new int[] {3, 6, 8, 10, 13, 17, 20}));
    }
}
