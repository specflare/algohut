package com.specflare.algohut.leetcode;

import com.specflare.algohut.leetcode.arrays.TwoSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumTest {
    @Test
    public void twoSumTest() {
        Assertions.assertArrayEquals(TwoSum.twoSum_v2(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        Assertions.assertArrayEquals(TwoSum.twoSum_v2(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        Assertions.assertArrayEquals(TwoSum.twoSum_v2(new int[]{3, 3}, 6), new int[]{0, 1});
    }
}
