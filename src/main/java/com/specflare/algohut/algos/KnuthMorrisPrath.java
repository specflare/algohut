package com.specflare.algohut.algos;

import com.specflare.algohut.Util;

/**
 * KMP searches for occurrences of a "word" W within a main "text string" S by employing the observation
 * that when a mismatch occurs, the word itself embodies sufficient information to determine where the
 * next match could begin, thus bypassing re-examination of previously matched characters.
 *
 * KMP works by precomputing a prefix table of the size of the word, that we use to skip
 * several letters at a time - not compare all leters everything.
 *
 * Example:
 *  S   = "ABC ABCDAB ABCDABCDABDE"
 *  W   = "ABCDABD"
 *  LPS =  0000120
 *
 *  If W has only distinct letters, LPS is all zeros.
 */
// Knuth Morris Prath Algorithm for string matching (strstr())
// https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
// https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm

public class KnuthMorrisPrath {
    public void KMPSearch(String W, String S) {
        int[] longestProperPrefix = computePrefixLengthArray(W);
        System.out.println("Input word: " + W);
        System.out.println("longestProperPrefix table: ");
        Util.printArray(longestProperPrefix, longestProperPrefix.length);
        int m = 0; // index for S[]
        int i = 0; // index for W[]

        while (m < S.length()) {
            if (W.charAt(i) == S.charAt(m)) {
                i++;
                m++;
            }
            if (i == W.length()) {
                System.out.println("Found pattern at index " + (m - i) + " in " + S);
                i = longestProperPrefix[i - 1];
            } else if (m < S.length() && W.charAt(i) != S.charAt(m)) {
                if (i != 0) {
                    i = longestProperPrefix[i - 1];
                } else {
                    m = m + 1;
                }
            }
        }
    }

    // LPA: Longest Prefix Array
    private int[] computePrefixLengthArray(String word) {
        int[] LPA = new int[word.length()];
        int prefixLen = 0;
        int i = 1;
        LPA[0] = 0;

        while (i < word.length()) {
            if (word.charAt(i) == word.charAt(prefixLen)) {
                prefixLen++;
                LPA[i++] = prefixLen;
            } else {
                if (prefixLen > 0) {
                    prefixLen = LPA[prefixLen - 1];
                } else {
                    LPA[i++] = 0;
                }
            }
        }

        return LPA;
    }

    public static void main(String args[]) {
        String W = "ABCDABD";
        String S = "ABC ABCDAB ABCDABCDABDE";
        new KnuthMorrisPrath().KMPSearch(W, S);
    }
}
