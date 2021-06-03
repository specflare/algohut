package com.specflare.algohut.leetcode.dp;

// You are given an array of binary strings strs and two integers m and n.
// Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
// Sample input: strs = ["10","0","1"], m = 1, n = 1

// https://leetcode.com/problems/ones-and-zeroes/
public class OnesAndZeros {
    public static class Pair {
        public int numZeros;
        public int numOnes;
        public Pair() {}
    }

    private static Pair countZerosAndOnes(String s) {
        Pair result = new Pair();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result.numZeros ++;
            } else if (s.charAt(i) == '1') {
                result.numOnes ++;
            }
        }

        return result;
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        Pair[] input = new Pair[strs.length];

        for (int i = 0; i < strs.length; i++) {
            input[i] = countZerosAndOnes(strs[i]);
        }

        // int[][][] dp = new int[input.length + 1][m + 1][n + 1];
        // return findMaxForm_r(input, 0, m, n, dp);
        return findMaxForm_iterative(input, m, n);
    }

    // recursive solution with memoization in 3D array.
    private static int findMaxForm_r(Pair[] zerosAndOnes, int k, int zeros, int ones, int[][][] dp) {
        // at every step we can either take pair[k] into consideration or not.
        // return the number of subsets taken into consideration => should be maximum.
        if (k == zerosAndOnes.length) {
            return 0;
        }

        if (zeros <= 0 && ones <= 0) {
            return 0;
        }

        if (zeros >= zerosAndOnes[k].numZeros && ones >= zerosAndOnes[k].numOnes) {
            int res = dp[k][zeros][ones];
            if (0 == res) {
                res = Math.max(
                        findMaxForm_r(zerosAndOnes, k + 1, zeros, ones, dp),
                        1 + findMaxForm_r(zerosAndOnes, k + 1,
                                zeros - zerosAndOnes[k].numZeros,
                                ones - zerosAndOnes[k].numOnes, dp));
                dp[k][zeros][ones] = res;
            }

            return res;
        }

        return findMaxForm_r(zerosAndOnes, k + 1, zeros, ones, dp);
    }

    // DP Iterative solution, 3D Array.
    private static int findMaxForm_iterative(Pair[] zerosAndOnes, int zeros, int ones) {
        int[][][] dp = new int[zerosAndOnes.length + 1][zeros + 1][ones + 1];

        for (int k = 0; k <= zerosAndOnes.length; k++) { // for each length
            for (int i = 0; i <= zeros; i++) {
                for (int j = 0; j <= ones; j++) {
                    if (k == 0) {
                        dp[k][i][j] = 0;
                    } else if (i >= zerosAndOnes[k - 1].numZeros && j >= zerosAndOnes[k - 1].numOnes) {
                        dp[k][i][j] = Math.max(
                          dp[k - 1][i][j],
                          1 + dp[k - 1][i - zerosAndOnes[k - 1].numZeros][j - zerosAndOnes[k - 1].numOnes]
                        );
                    } else {
                        dp[k][i][j] = dp[k - 1][i][j];
                    }
                }
            }
        }

        return dp[zerosAndOnes.length][zeros][ones];
    }
}
