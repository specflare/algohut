package com.github.petascalr.algohut.freestanding.leetcode;

public class LeetCode {
    // given 2 sorted arrays, find the median value in O(log(m + n))
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        return 0.0;
    }


    // find the length of the longest matching parentheses
    // https://leetcode.com/problems/longest-valid-parentheses/
    public static int longestValidParentheses(String s) {
        int sum_open = 0;
        int sum_close = 0;
        int lenBlock = 0;
        int lenPrev = 0;
        int maxlen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (')' == s.charAt(i)) {
                sum_close++;
            } else if ('(' == s.charAt(i)) {
                sum_open++;
            }

            if (sum_open < sum_close) {
                lenBlock = Math.min(sum_close, sum_open) * 2;
                maxlen = Math.max(maxlen, lenPrev + lenBlock);
                lenPrev = 0;
                sum_close = 0;
                sum_open = 0;
            }

            if (sum_open == sum_close) {
                lenBlock = sum_open + sum_close;
                maxlen = Math.max(maxlen, lenBlock + lenPrev);
                lenPrev += lenBlock;
                sum_open = 0;
                sum_close = 0;
            }

            if (sum_open > sum_close) {
                // sum_open > sum_close: ((() => len so far is 2, and we keep going...
                lenBlock = Math.min(sum_close, sum_open) * 2;
                maxlen = Math.max(maxlen, lenBlock);
            }
        }
        return maxlen;
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
}
