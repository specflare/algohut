package com.specflare.algohut.leetcode;

import com.specflare.algohut.leetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCodeTest {
    @Test
    public void isPalindrome() {
        Assertions.assertTrue(LeetCode.isPalindrome(121));
        Assertions.assertFalse(LeetCode.isPalindrome(-121));
        Assertions.assertFalse(LeetCode.isPalindrome(1212));

        Assertions.assertTrue(LeetCode.isPalindrome(0));
        Assertions.assertTrue(LeetCode.isPalindrome(-0));
        Assertions.assertTrue(LeetCode.isPalindrome(1));
        Assertions.assertTrue(LeetCode.isPalindrome(99));
        Assertions.assertTrue(LeetCode.isPalindrome(100000001));
        Assertions.assertTrue(LeetCode.isPalindrome(9870789));
    }

    @Test
    public void testIndexPosition() {
        Assertions.assertEquals(2, LeetCode.searchInsertPosition(new int[] {1, 3, 5, 6}, 5));
        Assertions.assertEquals(3, LeetCode.searchInsertPosition(new int[] {1, 3, 5, 6}, 6));
        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {1, 3, 5, 6}, 0));
        Assertions.assertEquals(4, LeetCode.searchInsertPosition(new int[] {1, 3, 5, 6}, 7));

        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {}, 7));
        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {}, 0));

        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5}, 0));
        Assertions.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5}, 10));
        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5}, 5));

        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5, 10}, 0));
        Assertions.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5, 10}, 7));
        Assertions.assertEquals(2, LeetCode.searchInsertPosition(new int[] {5, 10}, 12));
        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5, 10}, 5));
        Assertions.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5, 10}, 10));


        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 5));
        Assertions.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 10));
        Assertions.assertEquals(2, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 15));

        Assertions.assertEquals(0, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 2));
        Assertions.assertEquals(1, LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 7));
        Assertions.assertEquals(2,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 12));
        Assertions.assertEquals(3,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 18));

        Assertions.assertEquals(0,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 5));
        Assertions.assertEquals(1,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 10));
        Assertions.assertEquals(2,  LeetCode.searchInsertPosition(new int[] {5, 10, 15}, 15));
    }

    // [5,1,4,null,null,3,6]
    @Test
    public void isValidBSTTest() {
        Assertions.assertFalse(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)
                ))));

        Assertions.assertFalse(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(8,
                        new TreeNode(3),
                        new TreeNode(6)
                ))));

        Assertions.assertFalse(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4)
        )));

        Assertions.assertTrue(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(7)
        )));

        Assertions.assertTrue(LeetCode.isValidBST(new TreeNode(4)));
        Assertions.assertTrue(LeetCode.isValidBST(null));

        // [5,4,6,null,null,3,7]
        Assertions.assertFalse(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6,
                    new TreeNode(3),
                    new TreeNode(7)
                    )
        )));

        Assertions.assertTrue(LeetCode.isValidBST(new TreeNode(5,
                new TreeNode(Integer.MIN_VALUE),
                new TreeNode(Integer.MAX_VALUE)
        )));

        Assertions.assertTrue(LeetCode.isValidBST(new TreeNode(10,
                new TreeNode(5),
                new TreeNode(15,
                        new TreeNode(13),
                        new TreeNode(Integer.MAX_VALUE)
                )
        )));

        Assertions.assertFalse(LeetCode.isValidBST(new TreeNode(10,
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
        // Assertions.assertEquals(3, LeetCode.countEngodingWays_r("111"));

        // aaaa, aak, aka, kaa, kk
        Assertions.assertEquals(5, LeetCode.countEngodingWays_r("1111"));
        Assertions.assertEquals(5, LeetCode.countEngodingWays_iter("1111"));
        Assertions.assertEquals(8, LeetCode.countEngodingWays_iter("11111"));
    }
}

