package com.github.petascalr.algohut.algos.dynprog;

import org.junit.Assert;
import org.junit.Test;

public class ZeroSumSubArrayTest {
    @Test
    public void zeroSumSubArray() {
        Assert.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {4, 7, -6, -5, 4, 7}));
        Assert.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {3, 0, 5}));
        Assert.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {3, 0, -3}));
        Assert.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {0}));
        Assert.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {-1, 1}));
        Assert.assertTrue(ZeroSumSubArray.zeroSumSubArray(new int[] {4, 2, -3, 1, 6}));
    }
}
