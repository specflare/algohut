package com.specflare.algohut.leetcode;

import com.specflare.algohut.leetcode.trees.TreeNode;

public class LeetCode {

    // given 2 sorted arrays, find the median value in O(log(m + n))
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        return 0.0;
    }

    // https://leetcode.com/problems/palindrome-number/
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    // https://leetcode.com/problems/search-insert-position/
    public static int searchInsertPosition(int[] nums, int target) {
        if (0 == nums.length) {
            return 0;
        }

        return getIndexRec(nums, target, 0, nums.length - 1);
    }

    private static int getIndexRec(int[] nums, int target, int left, int right) {
        int middle = (left + right) / 2;

        if (nums[middle] == target) {
            return middle;
        }

        if (left >= right) {
            return target < nums[middle]
                    ? Math.max(0, left)
                    : Math.min(nums.length, right + 1);
        }

        if (target < nums[middle]) {
            return getIndexRec(nums, target, left, middle - 1);
        }

        return getIndexRec(nums, target, middle + 1, right);
    }

    // https://leetcode.com/problems/validate-binary-search-tree/

    // leftmost ancestor is minimum
    // rightmost ancestor is maximum
    public static boolean isValidBST(TreeNode node) {
        return isValidBST_r(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST_r(TreeNode node, int minRange, int maxRange) {
        if (null == node)
            return true;

        if (node.val < minRange || node.val > maxRange) {
            return false;
        }

        boolean leftOK = true;
        if (null != node.left) {
            leftOK =  node.left.val < node.val && isValidBST_r(node.left, minRange, node.val);
        }

        boolean rightOK = true;
        if (null != node.right) {
            rightOK = node.val < node.right.val && isValidBST_r(node.right, node.val, maxRange);
        }

        return leftOK && rightOK;
    }

//    // https://leetcode.com/problems/create-maximum-number/
//    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        /*
//            Let i and j be the iterators that iterate over num1 and num2
//            At any given time we have the following options:
//                1. Take num1[i] and go on
//                1'. Skip num1[i] and reevaluate
//                2. Take num2[j]
//                3.
//         */
//        if (k > nums1.length + nums2.length) {
//            return null;
//        }
//        return maxNumber_r(num1, num2, k, 0, 0);
//    }
//
//    public static int[] maxNumber_r(int[] nums1, int[] nums2, int k, int i, int j) {
//        int m = Math.max(nums1[i], nums2[j]);
//        // 3 Options: pick m, discard m and increment i, discard m and increment j.
//
//    }

    // given an input string like '1111' and a mapping a='1', b='2'...z='26'
    // in how many ways can we decode the input string '1111'.
    // aaaa, aak, aka, kaa, kk, kaa
    public static int countEngodingWays_r(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        if (s.length() == 2) {
            int val = Integer.parseInt(s.substring(0, 2));
            if (val <= 26) {
                return 2;
            }

            return 1;
        }

        int sum1 = countEngodingWays_r(s.substring(1));
        int sum2 = countEngodingWays_r(s.substring(2));
        return sum1 + sum2;
    }

    public static int countEngodingWays_iter(String s) {
        int[] vec = new int[s.length() + 1];

        vec[0] = 0;
        vec[1] = 1;
        int val2 = Integer.parseInt(s.substring(0, 2));
        if (val2 <= 26) {
            vec[2] = 2;
        } else {
            vec[2] = 1;
        }

        for (int i = 3; i <= s.length(); i++) {
            int val = Integer.parseInt(s.substring(i - 2, i));
            if (val <= 26) {
                // putem musca fie 2 caractere, fie unu
                vec[i] = vec[i - 1] + vec[i - 2];
            } else {
                vec[i] = vec[i - 1];
            }
        }

        return vec[s.length()];
    }
}
