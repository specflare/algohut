package com.specflare.algohut.leetcode.greedy;

import com.specflare.algohut.Util;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
 * if you are at nums[i], you can jump to any nums[i + j] where:
 *      0 <= j <= nums[i] and
 *      i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are
 * generated such that you can reach nums[n - 1].
 * Solution:
 * - traverse left to right.
 * - keep maximum jump from current.
 * - update
 * Complexity:
 *   - Time: O(n)
 *   - Space: O(n)
 */
// https://leetcode.com/problems/jump-game-ii/description/
// 45. Jump Game II (Medium)
// tags: [array] [greedy]
public class JumpGame2 {
    public int jump(int[] nums) {
        int maxJump = 0;
        int jumpCount = 0;

        for (int i = 0, jump = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(i + nums[i], maxJump);
            if (jump == i) {
                jump = maxJump;
                jumpCount++;
            }

            System.out.printf("i = %d, maxJump=%d, jump = %d\n", i, maxJump, jump);
        }

        return jumpCount;
    }

    public static void main(String[] args) {
        JumpGame2 jg2 = new JumpGame2();
        System.out.println(jg2.jump(new int[]{2, 3, 1, 1, 4}));

        System.out.println(jg2.jump(new int[]{2, 3, 0, 1, 4}));
    }
}
