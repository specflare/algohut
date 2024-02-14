package com.specflare.algohut.leetcode.arrays;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit
 *  of the integer. The digits are ordered from most significant to least significant in left-to-right order.
 *  The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */

// 66. Plus One (Easy)
// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            carry = sum / 10;
            sum = sum % 10;
            digits[i] = sum;
        }

        if (0 != carry) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        System.out.println(Arrays.toString(po.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(po.plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(po.plusOne(new int[]{9, 0,9,9})));
    }
}
