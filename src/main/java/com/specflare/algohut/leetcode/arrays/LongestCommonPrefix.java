package com.specflare.algohut.leetcode.arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */

// 14. Longest Common Prefix (Easy)
// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (0 == strs.length) {
            return "";
        }

        int shortestStringIndex = 0;
        int shortestStringLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (0 == strs[i].length()) {
                return "";
            }

            if (strs[i].length() < shortestStringLen) {
                shortestStringLen = strs[i].length();
                shortestStringIndex = i;
            }
        }

        int maxPrefixLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            int prefixLen = 0;
            for (int j = 0; j < shortestStringLen; j++) {
                if (strs[shortestStringIndex].charAt(j) == strs[i].charAt(j)) {
                    prefixLen = j + 1;
                } else break;
            }

            maxPrefixLen = Math.min(maxPrefixLen, prefixLen);
        }

        return strs[shortestStringIndex].substring(0, maxPrefixLen);
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println("prefix = " + lcp.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println("prefix = " + lcp.longestCommonPrefix(new String[] {"abcdef", "gessa", "rrtteew332"}));
        System.out.println("prefix = " + lcp.longestCommonPrefix(new String[] {"shower", "shower", "shower"}));
        System.out.println("prefix = " + lcp.longestCommonPrefix(new String[] {"shower", "", "shower"}));
    }
}
