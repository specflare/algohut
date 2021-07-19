package com.specflare.algohut.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor
 * higher than f will break, and any egg dropped at or below floor f will not break.
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n).
 * If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
 *
 * Return the minimum number of moves that you need to determine with certainty what the value of f is.
 */

// 887. Super Egg Drop (Very Hard)
// https://leetcode.com/problems/super-egg-drop/solution/
public class SuperEggDrop {
    public static int superEggDrop(int numEggs, int numFloors) {
        if (0 == numEggs || 0 == numFloors) {
            return 0;
        }

        if (1 == numEggs || 1 == numFloors) {
            return numFloors;
        }

        return superEggDrop_DP(numEggs, numFloors);
    }

    public static int superEggDrop_DP(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 0; i <= eggs; i++) {
            dp[i][0] = 0; // we have 0 floors => max 0 tries needed, no matter the number of eggs
            dp[i][1] = 1; // we have only 1 floor => max 1 try needed
        }

        for (int j = 0; j <= floors; j++) {
            dp[0][j] = 0;
            dp[1][j] = j; // if we have only 1 egg, we need to drop it at each floor => # moves = number of floors.
        }

        // first 2 rows and columns were already filled.
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                int minVal = Integer.MAX_VALUE;
                for (int h = 1; h <= j; h++) {
                    minVal = Math.min(minVal, 1 + Math.max(
                            dp[i - 1][h - 1], // egg breaks, so eggs-1, floors -1
                            dp[i][j - h]        // egg does not break,
                    ));
                }

                dp[i][j] = minVal;
            }
        }

        return dp[eggs][floors];
    }

    public static int superEggDrop_recursive(int numEggs, int numFloors) {
        if (1 == numEggs || 1 == numFloors || 0 == numFloors) {
            return numFloors;
        }

        int minVal = Integer.MAX_VALUE;

        for (int floor = 1; floor <= numFloors; floor++) {
            // we pick the best worst case
            // Case 1: egg breaks => we count 1 move and rerun for (eggs-1, floors-1)
            // Case 2: egg does not break => we count 1 move and rerun for (eggs, remaining floors = numFloors-currFloor)
            int numStepsEggBreaks = superEggDrop_recursive(numEggs - 1, floor - 1);
            int numStepsEggDoesntBreak = superEggDrop_recursive(numEggs, numFloors - floor);
            minVal = Math.min(minVal, 1 + Math.max(numStepsEggBreaks, numStepsEggDoesntBreak));
        }

        // System.out.println(String.format("eggs=%d, floors=%d, maxTries=%d", numEggs, numFloors, minVal));
        return minVal;
    }

    // explanation for this solution is here (Approach 1): https://leetcode.com/problems/super-egg-drop/solution/
    Map<Integer, Integer> memo = new HashMap<>();
    public int dp(int K, int N) {
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0)
                ans = 0;
            else if (K == 1)
                ans = N;
            else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K-1, x-1);
                    int t2 = dp(K, N-x);

                    if (t1 < t2)
                        lo = x;
                    else if (t1 > t2)
                        hi = x;
                    else
                        lo = hi = x;
                }

                ans = 1 + Math.min(
                        Math.max(dp(K-1, lo-1), dp(K, N-lo)),
                        Math.max(dp(K-1, hi-1), dp(K, N-hi)));
            }

            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop_recursive(1, 2));
        System.out.println(superEggDrop_recursive(2, 6));
        System.out.println(superEggDrop_recursive(3, 14));

        System.out.println("\n");
        System.out.println(superEggDrop_DP(1, 2));
        System.out.println(superEggDrop_DP(2, 6));
        System.out.println(superEggDrop_DP(3, 14));

    }
}
