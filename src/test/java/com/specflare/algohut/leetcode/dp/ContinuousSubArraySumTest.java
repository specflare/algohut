package com.specflare.algohut.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContinuousSubArraySumTest {
    @Test
    public void test() {
        Assertions.assertTrue(ContinuousSubArraySum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        Assertions.assertTrue(ContinuousSubArraySum.checkSubarraySum(new int[]{23,2,6,4,7}, 6));
        Assertions.assertTrue(ContinuousSubArraySum.checkSubarraySum(new int[]{10,20}, 3));
        Assertions.assertTrue(ContinuousSubArraySum.checkSubarraySum(new int[]{23,2,6,4,7}, 11));

        Assertions.assertFalse(ContinuousSubArraySum.checkSubarraySum(new int[]{10}, 2));
    }
}
