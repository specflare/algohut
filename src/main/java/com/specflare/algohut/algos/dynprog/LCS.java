package com.specflare.algohut.algos.dynprog;

/**
 * Steps to solve a DynProg problem
 *  1. Find the recursive relationship
 *  2. Draw the call tree from the recursive function
 *  3. Notice the Overlapping subproblems (i.e. recursive calls with the same data that can be cached)
 *  4. Cache the pre-computed sub-problems, and implement the algorithm iteratively.
 */

public class LCS {
    // Recursive solution, without memoization
    static int lcs_rec( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;

        if (X[m - 1] == Y[n - 1])
            return 1 + lcs_rec(X, Y, m-1, n-1);

        return Math.max(
                lcs_rec(X, Y, m, n - 1),
                lcs_rec(X, Y, m - 1, n));
    }

    // iterative solution, with memoization
    static int lcs_memoization( char[] X, char[] Y, int m, int n ) {
        int[][] L = new int[m + 1][n + 1];

        // Following steps build L[m+1][n+1] in bottom up fashion.
        // Note that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }

        return L[m][n];
    }
}
