package com.github.petascalr.algohut.freestanding.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCodeTest {
    @Test
    public void longestValidParenString() {
        Assert.assertEquals(8, LeetCode.longestValidParentheses(")()()((((())))"));
        Assert.assertEquals(0, LeetCode.longestValidParentheses(")"));
        Assert.assertEquals(0, LeetCode.longestValidParentheses("("));
        Assert.assertEquals(0, LeetCode.longestValidParentheses(")))((("));
        Assert.assertEquals(0, LeetCode.longestValidParentheses(")))))))"));
        Assert.assertEquals(0, LeetCode.longestValidParentheses("((((((("));
        Assert.assertEquals(2, LeetCode.longestValidParentheses("()"));
        Assert.assertEquals(2, LeetCode.longestValidParentheses("))()))"));
        Assert.assertEquals(4, LeetCode.longestValidParentheses(")()())"));
        Assert.assertEquals(12, LeetCode.longestValidParentheses(")()()(((())))))()"));
        Assert.assertEquals(12, LeetCode.longestValidParentheses("(()(((()"));
    }

    @Test
    public void isPalindrome() {
        Assert.assertTrue(LeetCode.isPalindrome(121));
        Assert.assertFalse(LeetCode.isPalindrome(-121));
        Assert.assertFalse(LeetCode.isPalindrome(1212));

        Assert.assertTrue(LeetCode.isPalindrome(0));
        Assert.assertTrue(LeetCode.isPalindrome(-0));
        Assert.assertTrue(LeetCode.isPalindrome(1));
        Assert.assertTrue(LeetCode.isPalindrome(99));
        Assert.assertTrue(LeetCode.isPalindrome(100000001));
        Assert.assertTrue(LeetCode.isPalindrome(9870789));
    }

    @Test
    public void testIndexPosition() {
        Assert.assertEquals(2, LeetCode.searchInsertPosition(new int[] {1, 3, 5, 6}, 5));
        Assert.assertEquals(3, LeetCode.searchInsertPosition(new int[] {1, 3, 5, 6}, 6));
        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {1, 3, 5, 6}, 0));
        Assert.assertEquals(4, LeetCode.searchInsertPosition(new int[] {1, 3, 5, 6}, 7));

        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {}, 7));
        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {}, 0));

        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5}, 0));
        Assert.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5}, 10));
        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5}, 5));

        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5, 10}, 0));
        Assert.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5, 10}, 7));
        Assert.assertEquals(2, LeetCode.searchInsertPosition(new int[] {5, 10}, 12));
        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5, 10}, 5));
        Assert.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5, 10}, 10));


        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 5));
        Assert.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 10));
        Assert.assertEquals(2, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 15));

        Assert.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 2));
        Assert.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 7));
        Assert.assertEquals(2,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 12));
        Assert.assertEquals(3,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 18));

        Assert.assertEquals(0,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 5));
        Assert.assertEquals(1,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 10));
        Assert.assertEquals(2,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 15));
    }
}

