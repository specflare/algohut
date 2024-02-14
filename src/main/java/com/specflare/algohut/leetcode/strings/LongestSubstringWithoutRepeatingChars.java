package com.specflare.algohut.leetcode.strings;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
// 3. Longest Substring Without Repeating Characters (Medium)
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<>();
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            while(q.contains(s.charAt(i))) {
                q.poll();
            }
            q.add(s.charAt(i));
            m = Math.max(m, q.size());
        }
        return m;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars lswrc = new LongestSubstringWithoutRepeatingChars();
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring(""));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("a"));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("ab"));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("abca"));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("12345678a12345"));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("abcabcd"));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("pwwkew"));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("abba"));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("abbccccccca"));
        System.out.println("maxLength=" + lswrc.lengthOfLongestSubstring("abcade"));
    }
}
