package com.specflare.algohut.algos.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZeroSumSubArrayTest {
    @Test
    public void zeroSumSubArray() {
        Assertions.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {4, 7, -6, -5, 4, 7}));
        Assertions.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {3, 0, 5}));
        Assertions.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {3, 0, -3}));
        Assertions.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {0}));
        Assertions.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {-1, 1}));
        Assertions.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {4, 2, -3, 1, 6}));
    }
}
