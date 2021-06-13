package com.specflare.algohut.leetcode.arrays;

import java.util.Arrays;

// Leetcode: 4. Median of Two Sorted Arrays
// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOf2SortedArrays {
    // Solution from: https://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;

        if (total % 2 == 0) {
            return (getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2)
                    + getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 - 1)) / 2.0;
        }

        return getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2);
    }

    // k is the index starting from 0
    private int getKth(int[] nums1, int i1, int j1, int[] nums2, int i2, int j2, int k) {
        if (j1 < i1) {
            return nums2[i2 + k];
        }

        if (j2 < i2) {
            return nums1[i1 + k];
        }

        if (k == 0) {
            return Math.min(nums1[i1], nums2[i2]);
        }

        int len1 = j1 - i1 + 1;
        int len2 = j2 - i2 + 1;

        int m1 = k * len1 / (len1 + len2);
        int m2 = k - m1 - 1;

        m1 += i1;
        m2 += i2;

        if (nums1[m1] < nums2[m2]) {
            k = k - (m1 - i1 + 1);
            j2 = m2;
            i1 = m1 + 1;
        } else {
            k = k - (m2 - i2 + 1);
            j1 = m1;
            i2 = m2 + 1;
        }

        return getKth(nums1, i1, j1, nums2, i2, j2, k);
    }

    // Following solution from GfG
    // ================================================================
    static double median(int a, int b) {
        return (a + b) / 2.0;
    }

    static double median(int a, int b, int c) {
        return a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    static double median(int a, int b, int c, int d) {
        int Max = Math.max(a, Math.max(b, Math.max(c, d)));
        int Min = Math.min(a, Math.min(b, Math.min(c, d)));
        return (a + b + c + d - Max - Min) / 2.0;
    }

    static double medianSingle(int arr[], int n) {
        if (n == 0)
            return -1;

        if (n % 2 == 0)
            return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;

        return arr[n / 2];
    }

    // This function assumes that size1 is smaller than or equal to size2
    // This function returns -1 if both arrays are empty
    static double findMedianUtil(int[] nums1, int size1, int[] nums2, int size2) {
        if (size1 == 0) {
            return medianSingle(nums2, size2);
        }

        // If the smaller array has only one element
        if (size1 == 1) {
            if (size2 == 1) {
                return median(nums1[0], nums2[0]);
            }

            // If the larger array has odd number of elements, then consider the middle 3 elements of
            // larger array and the only element of smaller array. Take few examples like following
            // nums1 = {9}, nums2 = {5, 8, 10, 20, 30}
            // nums1 = {1}, nums2 = {5, 8, 10, 20, 30}
            if (size2 % 2 == 1) {
                return median(nums2[size2 / 2],
                        (int) median(nums1[0], nums2[size2 / 2 - 1], nums2[size2 / 2 + 1])
                );
            }

            // If the larger array has even number of elements, then median will be one of the following 3 elements:
            // ... The middle two elements of larger array
            // ... The only element of smaller array
            return median(nums2[size2 / 2], nums2[size2 / 2 - 1], nums1[0]);
        }

        if (size1 == 2) {
            if (size2 == 2) {
                return median(nums1[0], nums1[1], nums2[0], nums2[1]);
            }

            // Case 5: If the larger array has odd number of elements,
            // then median will be one of the following 3 elements
            // 1. Middle element of larger array
            // 2. Max of first element of smaller array and element
            // just before the middle in bigger array
            // 3. Min of second element of smaller array and element
            // just after the middle in bigger array
            if (size2 % 2 == 1) {
                return median(nums2[size2 / 2], Math.max(nums1[0], nums2[size2 / 2 - 1]),
                        Math.min(nums1[1], nums2[size2 / 2 + 1]));
            }

            // Case 6: If the larger array has even number of elements,
            // then median will be one of the following 4 elements
            // 1) & 2) The middle two elements of larger array
            // 3) Max of first element of smaller array and element
            // just before the first middle element in bigger array
            // 4. Min of second element of smaller array and element
            // just after the second middle in bigger array
            return median(nums2[size2 / 2], nums2[size2 / 2 - 1],
                    Math.max(nums1[0], nums2[size2 / 2 - 2]),
                    Math.min(nums1[1], nums2[size2 / 2 + 1]));
        }

        int idxA = (size1 - 1) / 2;
        int idxB = (size2 - 1) / 2;

        /*
         * if nums1[idxA] <= nums2[idxB], then median
         must exist in nums1[idxA....] and nums2[....idxB]
         */
        if (nums1[idxA] <= nums2[idxB]) {
            return findMedianUtil(Arrays.copyOfRange(nums1, idxA, nums1.length),  size1 / 2 + 1,
                    nums2, size2 - idxA);
        }


        /*
         * if nums1[idxA] > nums2[idxB], then median
         must exist in nums1[...idxA] and nums2[idxB....]
         */
        return findMedianUtil(nums1, size1 / 2 + 1,
                Arrays.copyOfRange(nums2, idxB, nums2.length), size2 - idxA);
    }

    static double findMedian(int nums1[], int size1, int nums2[], int size2) {
        if (size1 > size2) {
            return findMedianUtil(nums2, size2, nums1, size1);
        }

        return findMedianUtil(nums1, size1, nums2, size2);
    }

    public static void main(String[] args) {
        MedianOf2SortedArrays m = new MedianOf2SortedArrays();
        System.out.println(m.findMedianSortedArrays(
                new int[]{1, 3},
                new int[]{2}
        ));

        System.out.println(m.findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{3, 4}
        ));
    }
}
