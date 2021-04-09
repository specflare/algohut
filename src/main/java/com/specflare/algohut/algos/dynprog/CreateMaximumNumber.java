package com.specflare.algohut.algos.dynprog;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two.
 * The relative order of the digits from the same array must be preserved.
 * Return an array of the k digits.
 *
 * Steps:
 *  -
 */
// https://leetcode.com/problems/create-maximum-number/
public class CreateMaximumNumber {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // make sure k is always lower than m + n.
        k = Math.min(nums1.length + nums2.length, k);
        return maxNum_r(nums1, nums2, k, 0, 0);
    }

    private static int[] maxNum_r(int[] n1, int[] n2, int k, int i, int j) {
        if (0 == k) {
            return new int[]{};
        }

        if (i == n1.length && j == n2.length) {
            return new int[]{};
        }

        int m = Math.max(n1[i], n2[j]);
        int ii = m == n1[i] ? i + 1 : i;
        int jj = m == n2[j] ? j + 1 : j;
        // take m into consideration
        // decision 1: take m into consideration and increment either i or j
        return null;
    }

    public static int compareNumbers(int[] num1, int[] num2) {
        if (num1.length < num2.length)
            return -1;

        if (num1.length > num2.length)
            return 1;

        // num1 and num2 have equal lengths, so we iterate every digit...
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] < num2[i]) {
                return -1;
            }

            if (num1[i] > num2[i]) {
                return 1;
            }
        }

        return 0;
    }

    public static int[] concat(int[] lhs, int[] rhs) {
        int[] result = new int[lhs.length + rhs.length];
        System.arraycopy(lhs, 0, result, 0, lhs.length);
        System.arraycopy(rhs, 0, result, result.length - 1, rhs.length);
        return result;
    }
}
