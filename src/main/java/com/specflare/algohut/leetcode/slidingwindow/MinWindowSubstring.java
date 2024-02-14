package com.specflare.algohut.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 *
 * Solution: sliding window through the bigger substring, building a map of character occurences.
 * at each step we check if map-of-t is included in map-of-s, and keep the minimum substring.
 */

// https://leetcode.com/problems/minimum-window-substring/description/
// 76. Minimum Window Substring (Hard)
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }

        System.out.printf("s = %s(%d), t = %s(%d).\n", s, s.length(), t, t.length());
        int minSize = Integer.MAX_VALUE;
        String minString = "";
        int left = 0;
        int right = t.length();
        Map<Character, Integer> mt = buildMap(t, 0, t.length());
        Map<Character, Integer> ms = buildMap(s, left, right);
        System.out.println("ms = " + ms + ", mt = " + mt);

        while (right <= s.length()) {
            if (contains(ms, mt)) {
                String currString = s.substring(left, right);
                System.out.printf("currString = %s (containing t=%s). length=%d.\n", currString, t, currString.length());
                if (currString.length() < minSize) {
                    minString = currString;
                    minSize = minString.length();
                }
                ms.put(s.charAt(left), ms.get(s.charAt(left)) - 1);
                System.out.printf("Removed %c. substr = %s, left=%d, right=%d, map=%s\n", s.charAt(left), s.substring(left+1, right), left+1, right, ms);
                left++;
            } else {
                 if (right < s.length()) {
                    ms.put(s.charAt(right), ms.getOrDefault(s.charAt(right), 0) + 1);
                    System.out.printf("Adding %c. substr=%s, left=%d, right=%d, map=%s\n", s.charAt(right), s.substring(left, right), left, right, ms);
                 }

                 right++;
            }
        }

        return minString;
    }

    private boolean contains(Map<Character, Integer> ms, Map<Character, Integer> mt) {
        if (ms.size() < mt.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> kvp : mt.entrySet()) {
            if (!ms.containsKey(kvp.getKey()) || ms.get(kvp.getKey()) < kvp.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> buildMap(String s, int left, int right) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = left; i < right; i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }
        return m;
    }

    public static void main(String[] args) {
        MinWindowSubstring p = new MinWindowSubstring();
        System.out.println(p.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(p.minWindow("a","a"));
        System.out.println(p.minWindow("a","aa"));
    }
}
