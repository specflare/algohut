package com.specflare.algohut.leetcode.arrays;

import java.util.Arrays;

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
