package com.specflare.algohut.leetcode;

import com.specflare.algohut.leetcode.dp.OnesAndZeros;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnesAndZerosTest {
    @Test
    public void test() {
        Assertions.assertEquals(4,
                OnesAndZeros.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));

        Assertions.assertEquals(2,
                OnesAndZeros.findMaxForm(new String[]{"10","0","1"}, 1, 1));
    }
}
