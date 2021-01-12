package com.github.petascalr.algohut.freestanding.leetcode;

import com.github.petascalr.algohut.trees.BinarySearchTree;
import com.github.petascalr.algohut.trees.BinaryTreeNode;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class LeetCodeTest {
    @Test
    public void longestValidParenString() {
        Assert.assertEquals(0, LeetCode.longestValidParentheses(""));
        Assert.assertEquals(0, LeetCode.longestValidParentheses(")"));
        Assert.assertEquals(0, LeetCode.longestValidParentheses("("));
        Assert.assertEquals(0, LeetCode.longestValidParentheses(")))))))"));
        Assert.assertEquals(0, LeetCode.longestValidParentheses("((((((("));
        Assert.assertEquals(0, LeetCode.longestValidParentheses(")("));
        Assert.assertEquals(0, LeetCode.longestValidParentheses(")))((("));
        // Assert.assertEquals(8, LeetCode.longestValidParentheses(")()()((((())))"));
        Assert.assertEquals(2, LeetCode.longestValidParentheses("()"));
        Assert.assertEquals(2, LeetCode.longestValidParentheses("))()))"));
        Assert.assertEquals(4, LeetCode.longestValidParentheses(")()())"));
        Assert.assertEquals(12, LeetCode.longestValidParentheses(")()()(((())))))()"));
        Assert.assertEquals(2, LeetCode.longestValidParentheses("(()(((()"));
        // Assert.assertEquals(4, LeetCode.longestValidParentheses("(()())"));

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

    // [5,1,4,null,null,3,6]
    @Test
    public void isValidBSTTest() {
        Assert.assertFalse(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)
                ))));

        Assert.assertFalse(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(8,
                        new TreeNode(3),
                        new TreeNode(6)
                ))));

        Assert.assertFalse(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4)
        )));

        Assert.assertTrue(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(7)
        )));

        Assert.assertTrue(LeetCode.isValidBST(new TreeNode(4)));
        Assert.assertTrue(LeetCode.isValidBST(null));

        // [5,4,6,null,null,3,7]
        Assert.assertFalse(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6,
                    new TreeNode(3),
                    new TreeNode(7)
                    )
        )));

        Assert.assertTrue(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(Integer.MIN_VALUE),
                new TreeNode(Integer.MAX_VALUE)
        )));

        Assert.assertTrue(LeetCode.isValidBST(new TreeNode(10,
                new TreeNode(5),
                new TreeNode(15,
                        new TreeNode(13),
                        new TreeNode(Integer.MAX_VALUE)
                )
        )));

        Assert.assertFalse(LeetCode.isValidBST(new TreeNode(10,
                new TreeNode(5),
                new TreeNode(15,
                        new TreeNode(Integer.MIN_VALUE),
                        new TreeNode(Integer.MAX_VALUE)
                )
        )));
    }

    // smallestSufficientTeam
//    @Test
//    public void smallestSufficientTeamTest() {
//        String[] skills = new String[] {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
//        List<List<String>> people = List.of(
//                List.of("algorithms","math","java"),
//                List.of("algorithms","math","reactjs"),
//                List.of("java","csharp","aws"),
//                List.of("reactjs","csharp"),
//                List.of("csharp", "math"),
//                List.of("aws","java")
//        );
//
//        LeetCode.smallestSufficientTeam(skills, people);
//    }

    @Test
    public void countEngodingWaysTest() {
        // Assert.assertEquals(3, LeetCode.countEngodingWays_r("111"));

        // aaaa, aak, aka, kaa, kk
        Assert.assertEquals(5, LeetCode.countEngodingWays_r("1111"));
        Assert.assertEquals(5, LeetCode.countEngodingWays_iter("1111"));
        Assert.assertEquals(8, LeetCode.countEngodingWays_iter("11111"));
    }
}

