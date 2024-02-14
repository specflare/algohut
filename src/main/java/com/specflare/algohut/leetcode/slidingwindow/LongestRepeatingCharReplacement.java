package com.specflare.algohut.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of the string and
 * change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after
 * performing the above operations.
 *
 * Solution: Sliding Window
 */

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
// 424. Longest Repeating Character Replacement (Medium)
public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            m.put(s.charAt(right), m.getOrDefault(s.charAt(right), 0) + 1);

            int[] res = sizeOfMapAndMaxChar(m);
            if (res[0] - res[1] > k) {
                m.put(s.charAt(left), m.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    private int[] sizeOfMapAndMaxChar(Map<Character, Integer> m) {
        int result = 0;
        int maxChar = 0;
        for (Map.Entry<Character, Integer> kvp : m.entrySet()) {
            result += kvp.getValue();
            maxChar = Math.max(maxChar, kvp.getValue());
        }
        return new int[] {result, maxChar};
    }

    public static void main(String[] args) {
        LongestRepeatingCharReplacement p = new LongestRepeatingCharReplacement();
        System.out.println(p.characterReplacement("ABAB", 2));
        System.out.println(p.characterReplacement("AABABBA", 1));

        System.out.println(p.characterReplacement("ABAA", 0));
    }
}
