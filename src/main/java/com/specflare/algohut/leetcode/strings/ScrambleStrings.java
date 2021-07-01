package com.specflare.algohut.leetcode.strings;

import java.util.Arrays;

/**
 * We can scramble a string s to get a string t using the following algorithm:
 *
 * If the length of the string is 1, stop.
 * If the length of the string is > 1, do the following:
 * Split the string into two non-empty substrings at a random index, i.e., if the string is s,
 * divide it to x and y where s = x + y.
 * Randomly decide to swap the two substrings or to keep them in the same order. i.e.,
 * after this step, s may become s = x + y or s = y + x.
 * Apply step 1 recursively on each of the two substrings x and y.
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
 */

// 87. Scramble String: https://leetcode.com/problems/scramble-string/
public class ScrambleStrings {
    // return true if s2 is a scrambled string of s1, otherwise, return false.
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if(s1.length() == 0 || s1.equals(s2)) {
            return true;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (!new String(arr1).equals(new String(arr2))) {
            return false;
        }

        boolean result = false;
        for (int i = 1; i < s1.length(); i++) {
            String left1 = s1.substring(0, i);
            String right1 = s1.substring(i);

            String left2 = s2.substring(0, i);
            String right2 = s2.substring(i);

            result = result || (isScramble(left1, left2) && isScramble(right1, right2));
        }

        return result;
    }

    public static void main(String[] args) {
        ScrambleStrings ss = new ScrambleStrings();
        System.out.println(ss.isScramble("great", "rgeat"));
    }
}
