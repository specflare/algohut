package com.specflare.algohut.leetcode.greedy;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 *
 * Solution:
 * 1. We start from end to beginning.
 * 2. The value of each element must be >= to the distance remaining to finish. If yes, update 'finish' to current pos.
 * 3. At the end (i == 0), finish must reach the beginning (finish == 0).
 */
// https://leetcode.com/problems/jump-game/description/
// 55. Jump Game (Medium)
// Tags: [array], [greedy]
public class JumpGame {
    public boolean canJump(int[] nums) {
        int finish = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= finish - i) {
                finish = i;
            }
        }

        return finish == 0;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[] {2,3,1,1,4}));
        System.out.println(jg.canJump(new int[] {3,2,1,0,4}));
    }
}
