package com.specflare.algohut.algos.dp;

/**
 * Problem: given 2 sequences of different length, find the longest common sub-sequence.
 *
 * Steps to solve a DynProg problem
 *  1. Find the recursive relationship
 *  2. Draw the call tree from the recursive function
 *  3. Notice the Overlapping sub-problems (i.e. recursive calls with the same value for params that can be cached)
 *  4. Cache the pre-computed sub-problems, and implement the algorithm iteratively.
 */

public class LCS {
    // Recursive solution, without memoization
    static int lcs_rec( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;

        if (X[m - 1] == Y[n - 1])
            return 1 + lcs_rec(X, Y, m - 1, n - 1);

        return Math.max(
                lcs_rec(X, Y, m, n - 1),
                lcs_rec(X, Y, m - 1, n));
    }

    // iterative solution, with tabulation
    static int lcs_memoization( char[] X, char[] Y, int m, int n ) {
        int[][] dp = new int[m + 1][n + 1];

        // Following steps build dp[m+1][n+1] in bottom up fashion.
        // Note that dp[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcs_rec(new char[] {'a', 'b', 'c', 'd', 'e'}, new char[] {'b', 'c', 'z', 'e'}, 5, 4));
    }
}
