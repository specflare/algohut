package com.specflare.algohut.algos.backtracking;

import com.specflare.algohut.Util;

import java.util.Arrays;

// A knight visits all chess squares exactly once.
// Status: OK. Both solutions work!
public class KnightJump {
    private static final int[] dx = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void knightJump(int n, int currRow, int currCol, int endRow, int endCol) {
        int[][] visit = new int[n][n];
        visit[currRow][currCol] = 1;

        System.out.println("First solution: ");
        System.out.println(knightJumpOnlyFirstSolution_r(n, visit, currRow, currCol, endRow, endCol, 1));

        for (int[] row : visit) {
            Arrays.fill(row, 0);
        }
        visit[currRow][currCol] = 1;
        System.out.println("\n\nAll solutions: ");
        knightJumpAllSolututions_r(n, visit, currRow, currCol, endRow, endCol, 1);
    }

    // naive implementation that generates all possible solutions
    private static void knightJumpAllSolututions_r(int n, int[][] visit, int currRow, int currCol,
                                                   int endRow, int endCol, int depth) {
        if (currRow == endRow && currCol == endCol && depth == n * n) {
            Util.printMatrix(visit);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int newRow = currRow + dy[i];
            int newCol = currCol + dx[i];

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                continue;
            }

            if (visit[newRow][newCol] != 0) {
                continue;
            }

            visit[newRow][newCol] = visit[currRow][currCol] + 1;
            knightJumpAllSolututions_r(n, visit, newRow, newCol, endRow, endCol, depth + 1);
            visit[newRow][newCol] = 0;
        }
    }

    // naive implementation that generates only the 1st solution
    private static boolean knightJumpOnlyFirstSolution_r(int n, int[][] visit, int currRow, int currCol,
                                                         int endRow, int endCol, int depth) {
        if (currRow == endRow && currCol == endCol && (depth == n * n)) {
            Util.printMatrix(visit);
            return true;
        }

        for (int i = 0; i < dx.length; i++) {
            int newRow = currRow + dy[i];
            int newCol = currCol + dx[i];
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || visit[newRow][newCol] != 0) {
                continue;
            }
            visit[newRow][newCol] = visit[currRow][currCol] + 1;
            if (knightJumpOnlyFirstSolution_r(n, visit, newRow, newCol, endRow, endCol, depth + 1))
                return true;

            visit[newRow][newCol] = 0;
        }

        return false;
    }

    public static void main(String[] args) {
        int boardSize = 5;
        knightJump(boardSize, 0, 0, boardSize - 1,boardSize - 1);
    }
}
