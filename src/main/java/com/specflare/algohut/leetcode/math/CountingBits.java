package com.specflare.algohut.leetcode.math;

import com.specflare.algohut.Util;

// 338. Counting Bits (Easy)
// https://leetcode.com/problems/counting-bits/
public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = popCount(i);
        }

        return result;
    }

    private int popCount(int n) {
        int result = 0;
        while (0 != n) {
            result += (0 != (n & 1)) ? 1 : 0;
            n >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();

        int[] r1 = cb.countBits(2);
        Util.printArray(r1, r1.length);

        int[] r2 = cb.countBits(5);
        Util.printArray(r2, r2.length);
    }
}
