package com.specflare.algohut.leetcode.backtracking;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of
 * words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation
 * sequences from beginWord to endWord, or an empty list if no such sequence exists.
 * Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 */
// 126. Word Ladder II (Hard) - NOT WORKING YET !!!
// https://leetcode.com/problems/word-ladder-ii/
public class WordLadder2 {
    Map<String, List<String>> adjMatrix = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsSet = new HashSet<>(wordList);
        wordsSet.add(beginWord);

        for (String word1 : wordsSet) {
            List<String> connections = new ArrayList<>();
            for (String word2 : wordsSet) {
                if (differByOneLetter(word1, word2)) {
                    connections.add(word2);
                }
            }

            adjMatrix.put(word1, connections);
        }

        Stack<String> sol = new Stack<>();
        sol.add(beginWord);
        solve_r(endWord, sol);

        return result;
    }

    private void solve_r(String endWord, Stack<String> sol) {
        if (sol.peek().equals(endWord)) {
            // we copy the stack to the result;

            for (int i = 0; i < sol.size(); i++) {
                sol.add(sol.get(i));
            }

            result.add((List<String>)sol.clone());
            return;
        }
    }

    private boolean differByOneLetter(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count > 1) {
                    return false;
                }
            }
        }

        return (1 == count);
    }
}
