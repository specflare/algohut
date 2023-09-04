package com.specflare.algohut.leetcode.arrays;

// 242. Valid Anagram (Easy)
// https://leetcode.com/problems/valid-anagram/description/

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
 * using all the original letters exactly once.
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> occ = new HashMap<>();
        for (int i = 0; i < s.length(); i++ ) {
            occ.put(s.charAt(i), occ.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++ ) {
            int count = occ.getOrDefault(t.charAt(i), -1);
            if (count == -1) {
                return false;
            }
            occ.put(t.charAt(i), count - 1);
        }

        boolean result = occ.values().stream().allMatch(val -> val == 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "tac"));
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("anagram", "nagarama"));
        System.out.println(isAnagram("anamaria", "maraanaa"));
    }
}
