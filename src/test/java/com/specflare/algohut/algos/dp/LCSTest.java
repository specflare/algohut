package com.specflare.algohut.algos.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LCSTest {

    @Test
    public void lcsRecTest() {
        String s1 = "ABCDEFGH";
        String s2 = "XBZCYF";
        Assertions.assertEquals( 3, LCS.lcs_rec(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length() ));
    }

    public void lcsMemTest() {
        String s1 = "ABCDEFGH";
        String s2 = "XBZCYF";
        Assertions.assertEquals(3, LCS.lcs_memoization(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length() ));
    }
}
