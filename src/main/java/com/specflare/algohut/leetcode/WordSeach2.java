package com.specflare.algohut.leetcode;

import java.util.*;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */

// https://leetcode.com/problems/word-search-ii/
public class WordSeach2 {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean leaf;
        public TrieNode() {
            children = new HashMap<>();
            this.leaf = false;
        }

        public void addWord(String word) {
            addWord_r(word, 0);
        }

        private void addWord_r(String word, int i) {
            if (i < word.length()) {
                TrieNode node = children.get(word.charAt(i));

                if (null != node) {
                    node.addWord_r(word, i + 1);
                } else {
                    TrieNode newNode = new TrieNode();
                    newNode.addWord_r(word, i + 1);
                    children.put(word.charAt(i), newNode);
                }
            } else {
                this.leaf = true;
            }
        }

        public TrieNode getNode(char c) {
            return children.get(c);
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode trie, String wordSoFar, Set<String> result) {
        visited[i][j] = true;

        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length || visited[newX][newY]) {
                continue;
            }

            char newChar = board[newX][newY];
            TrieNode childNode = trie.getNode(newChar);
            if (null != childNode) {
                visited[newX][newY] = true;

                if (childNode.leaf) {
                    result.add(wordSoFar + newChar);
                }

                dfs(board, visited, newX, newY, childNode, wordSoFar + newChar, result);
                visited[newX][newY] = false;
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (null == board) {
            return null;
        }

        final TrieNode trie = new TrieNode();
        Set<String> result = new TreeSet<>();
        for (String word : words) {
            trie.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                TrieNode node = trie.getNode(board[i][j]);
                if (null != node) {
                    if (node.leaf) {
                        result.add(Character.toString(board[i][j]));
                    }

                    dfs(board, visited, i, j, node, Character.toString(board[i][j]), result);
                }
            }
        }

        return new LinkedList<>(result);
    }

    public static void main(String[] args) {
        WordSeach2 ws = new WordSeach2();

        char[][] board = new char[][] {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};

        System.out.println(ws.findWords(board, new String[] {"oath", "pea", "eat", "rain"}));
        System.out.println(ws.findWords(board, new String[] {"kaa", "ka", "kaaa", "kaaap", "kak", "vrena", "n", "vrenaaoeiiflkath"}));
        System.out.println(ws.findWords(board, new String[] {"oath","pea","eat","rain","hklf", "hf"}));
        System.out.println(ws.findWords(board, new String[] {"n"}));

        System.out.println(ws.findWords(board, new String[] {"taer", "thkr", "oeiiflv", "oaanerv", "oathkrv"}));

        char[][] board2 = new char[][] {{'a', 'b'}, {'c', 'd'}};
        System.out.println(ws.findWords(board2, new String[] {"abcd"}));

        char[][] board3 = new char[][] {
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'}
        };

        System.out.println(ws.findWords(board3, new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
    }
}
