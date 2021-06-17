package com.specflare.algohut.algos;

import com.specflare.algohut.Util;

// Knuth Morris Prath Algorithm for string matching (strstr())
// https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
public class KMP {
    public void KMPSearch(String word, String text) {
        int[] longestProperPrefix = computePrefixLengthArray(word);

        int j = 0; // index for word[]
        int i = 0; // index for text[]

        while (i < text.length()) {
            if (word.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == word.length()) {
                System.out.println("Found pattern at index " + (i - j));
                j = longestProperPrefix[j - 1];
            }

            // mismatch after j matches
            else if (i < text.length() && word.charAt(j) != text.charAt(i)) {
                // Do not match longestProperPrefix[0..longestProperPrefix[j-1]] characters,
                // they will match anyway
                if (j != 0) {
                    j = longestProperPrefix[j - 1];
                }
                else {
                    i = i + 1;
                }
            }
        }
    }

    // LPA: Longest Prefix Array
    private int[] computePrefixLengthArray(String word) {
        // length of the previous longest prefix suffix
        int[] prefixLength = new int[word.length()];
        int prefixLen = 0;
        int i = 1;
        prefixLength[0] = 0; // lps[0] is always 0

        while (i < word.length()) {
            if (word.charAt(i) == word.charAt(prefixLen)) {
                prefixLength[i++] = ++prefixLen;
            } else {// (word[i] != word[prefixLen])
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (prefixLen > 0) {
                    prefixLen = prefixLength[prefixLen - 1];
                }
                else { // if (prefixLen == 0)
                    prefixLength[i++] = prefixLen;
                }
            }
        }

        Util.printArray(prefixLength);
        return prefixLength;
    }

    public static void main(String args[]) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP().KMPSearch(pat, txt);
    }
}
