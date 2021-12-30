package com.specflare.algohut.leetcode.strings;

import com.specflare.algohut.Util;

import java.util.Arrays;

// https://leetcode.com/problems/regular-expression-matching/
// 10. Regular Expression Matching (Hard)
// Status: both solutions are working (iter DP + rec DP)
public class RegularExpressionsMatching {
    public void driver(String s, String p, boolean expected) {
        boolean res = isMatch(s, p);
        System.out.printf("s='%s', p='%s', r=%s, RESULT=%s\n", s, p, res ? "T" : "F", res == expected ? "PASS" : "FAIL");
        System.out.println("------------------------------------\n");
    }

    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length()][p.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        return isMatch_rec(s, p, s.length() - 1, p.length() - 1, memo) != 0;
    }

    public boolean isMatch_DP(String s, String p) {
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        memo[0][0] = true;
        // memo[i][0] = false, because the empty pattern only matches the empty string.
        // memo[0][j] = true, only if the pattern up to j - 1 matches the empty string, i.e. p=x*p*m*n*...
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                memo[0][j] = j < 2 || memo[0][j - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    memo[i][j] = memo[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {

                    // we have 4 possibilities:
                    // a) the * succeeds a '.', in which case, we just return true.
                    if (p.charAt(j - 2) == '.') {
                        // we have .* in pattern, so we match everything
                        memo[i][j] |= memo[i - 1][j];
                    }

                    // b) The * cancels out the last character, so we just ignore the last 2 chars from the pattern
                    memo[i][j] |= memo[i][j - 2];

                    // c) The * means 1 repetition, so we just ignore the * operator
                    memo[i][j] |= memo[i][j - 1];

                    // d) The * means 2 repetitions, so we just repeat the last char one more time.
                    if (p.charAt(j - 2) == s.charAt(i - 1)) {
                        memo[i][j] |= memo[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                System.out.printf("%s ", memo[i][j] ? "1" : "0");
            }
            System.out.println();
        }

        return memo[s.length()][p.length()];
    }

    public int isMatch_rec(String s, String p, int i, int j, int[][] memo) {
        // System.out.printf("i = %d, j = %d\n", i, j);
        if (j < 0) {
            // we finished the pattern
            if (i < 0) {
                // we also finished the string => true
                return 1;
            }

            // we finished the patter, but we still have string remaining => false;
            return 0;
        }

        if (i < 0) {
            if (p.charAt(j) == '*') {
                return isMatch_rec(s, p, i, j - 2, memo);
            }

            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            int result = isMatch_rec(s, p, i - 1, j - 1, memo);
            memo[i][j] = result;
            return result;
        }

        if (p.charAt(j) == '*') {
            int v1 = isMatch_rec(s, p, i, j - 1, memo); // we just discard the star
            int v2 = isMatch_rec(s, p, i, j - 2, memo); // we discard the * and the char before it.

            int v3 = (s.charAt(i) == p.charAt(j - 1) || (p.charAt(j - 1) == '.')) ? 1 : 0;
            v3 &= isMatch_rec(s, p, i - 1, j, memo); // * just doubles the last char before it

            int result = v1 | v2 | v3;
            memo[i][j] = result;
            return result;
        }

        memo[i][j] = 0;
        return 0;
    }

    public static void main(String[] args) {
        RegularExpressionsMatching rem = new RegularExpressionsMatching();
        rem.driver("a", ".", true);
        rem.driver("ab", "..", true);
        rem.driver("ab", "...*", true);
        rem.driver("aa", "a", false);
        rem.driver("aa", "a*", true);
        rem.driver("ab", "a*", false);
        rem.driver("ab", ".*", true);

        rem.driver("ababab", "ab.*b", true);

        rem.driver("abc", "ab.", true);
        rem.driver("", "a*", true);
        rem.driver("abcdefgh", "ab.*", true);
        rem.driver("abcd", "ab.*cd", true);

        rem.driver("bcd", "bc*cd", true);
        rem.driver("abcdefgh", "a.c.*f.*h*", true);
        rem.driver("aab", "c*a*b", true);
        rem.driver("mississippi","mis*is*p*.", false);
        rem.driver("mississippi","mis*is*ip*.", true);
        rem.driver("aab", "b.*", false);
    }
}
