package com.specflare.algohut.leetcode.backtracking;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all the following rules:
 *  - Each of the digits 1-9 must occur exactly once in each row.
 *  - Each of the digits 1-9 must occur exactly once in each column.
 *  - Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *
 * The '.' character indicates empty cells.
 */

// https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    private static final int SIZE = 9;

    private void printBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean solveSudoku_r(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                for (char c = '1'; c <= '9'; c++) {
                    board[i][j] = c;

                    if (isValidSoFar(board, i, j) && solveSudoku_r(board)) {
                        return true;
                    }

                    board[i][j] = '.';
                }

                return false;
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        solveSudoku_r(board);
    }

    private boolean isValidSoFar(char[][] board, int row, int col) {
        int[] lookup1 = new int[9];
        int[] lookup2 = new int[9];
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] != '.') {
                lookup1[board[row][j] - '1'] ++;
            }

            if (board[j][col] != '.') {
                lookup2[board[j][col] - '1'] ++;
            }
        }

        for (int j = 0; j < board.length; j++) {
            if (lookup1[j] > 1 || lookup2[j] > 1) {
                return false;
            }
        }

        // validate 3x3 square where [row, col] is present
        row /= 3;
        col /= 3;

        int start_row = row * 3;
        int start_col = col * 3;

        int end_row = start_row + 3;
        int end_col = start_col + 3;

        Arrays.fill(lookup1, 0);

        for (int i = start_row; i < end_row; i++) {
            for (int j = start_col; j < end_col; j++) {
                if (board[i][j] != '.') {
                    lookup1[board[i][j] - '1'] ++;
                }
            }
        }

        for (int j = 0; j < board.length; j++) {
            if (lookup1[j] > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        SudokuSolver ss = new SudokuSolver();
        System.out.println("\nOriginal board:");
        ss.printBoard(board1);
        ss.solveSudoku(board1);

        System.out.println("\nSolved board:");
        ss.printBoard(board1);
    }
}
