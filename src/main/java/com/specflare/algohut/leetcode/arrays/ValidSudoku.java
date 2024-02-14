package com.specflare.algohut.leetcode.arrays;

import java.util.Set;
import java.util.TreeSet;

// https://leetcode.com/problems/valid-sudoku/
// 36. Valid Sudoku (Medium)
// Tags: [matrix] [set]
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // validate each column and row
        for (int i = 0; i < 9; i++) {
            int col_cnt = 0;
            int row_cnt = 0;
            Set<Character> col_set = new TreeSet<>();
            Set<Character> row_set = new TreeSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    col_cnt++;
                    col_set.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    row_cnt++;
                    row_set.add(board[i][j]);
                }
            }

            if (col_set.size() != col_cnt || row_set.size() != row_cnt) {
                return false;
            }
        }

        // validate each 3x3 square
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int end_row = i * 3 + 3;
                int end_col = j * 3 + 3;

                int cnt = 0;
                Set<Character> s = new TreeSet<>();
                for (int ii = i * 3; ii < end_row; ii++) {
                    for (int jj = j * 3; jj < end_col; jj++) {
                        if (board[ii][jj] != '.') {
                            cnt ++;
                            s.add(board[ii][jj]);
                        }
                    }
                }

                if (s.size() != cnt) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board =
            {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
            };

        System.out.println(isValidSudoku(board)); // true

        char[][] board_f =
            {
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
            };
        System.out.println(isValidSudoku(board_f)); // false
    }
}
