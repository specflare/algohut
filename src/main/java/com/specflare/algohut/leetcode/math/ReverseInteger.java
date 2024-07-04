package com.specflare.algohut.leetcode.math;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit
 * integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers
 * (signed or unsigned).
 */
// https://leetcode.com/problems/reverse-integer/description/
// 7. Reverse Integer (Medium/Easy)
public class ReverseInteger {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        int result = 0;
        while (x > 0) {
            int remainder = x % 10;
            if (result > (Integer.MAX_VALUE - remainder) / 10) {
                return 0;
            }
            result = result * 10 + remainder;
            x /= 10;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));
        System.out.println(ri.reverse(-123));
        System.out.println(ri.reverse(120));
    }
}
