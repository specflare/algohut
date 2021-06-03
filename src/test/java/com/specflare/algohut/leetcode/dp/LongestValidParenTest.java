package com.specflare.algohut.leetcode.dp;

import com.specflare.algohut.leetcode.dp.LongestValidParen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestValidParenTest {
    @Test
    public void longestValidParenString() {
        Assertions.assertEquals(0, LongestValidParen.longestValidParentheses_v2(""));
        Assertions.assertEquals(0, LongestValidParen.longestValidParentheses_v2(")"));
        Assertions.assertEquals(0, LongestValidParen.longestValidParentheses_v2("("));
        Assertions.assertEquals(0, LongestValidParen.longestValidParentheses_v2(")))))))"));
        Assertions.assertEquals(0, LongestValidParen.longestValidParentheses_v2("((((((("));
        Assertions.assertEquals(0, LongestValidParen.longestValidParentheses_v2(")("));
        Assertions.assertEquals(0, LongestValidParen.longestValidParentheses_v2(")))((("));
        Assertions.assertEquals(8, LongestValidParen.longestValidParentheses_v2(")()()((((())))"));
        Assertions.assertEquals(2, LongestValidParen.longestValidParentheses_v2("()"));
        Assertions.assertEquals(2, LongestValidParen.longestValidParentheses_v2("))()))"));
        Assertions.assertEquals(4, LongestValidParen.longestValidParentheses_v2(")()())"));
        Assertions.assertEquals(12,LongestValidParen.longestValidParentheses_v2(")()()(((())))))()"));
        Assertions.assertEquals(2, LongestValidParen.longestValidParentheses_v2("(()(((()"));
        Assertions.assertEquals(6, LongestValidParen.longestValidParentheses_v2("(()())"));
    }
}
