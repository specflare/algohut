package com.specflare.algohut.leetcode.arrays.sums;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4, all of length n, return
 * the number of tuples (i, j, k, l) such that:
 *  - 0 <= i, j, k, l < n
 *  - nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 *  Solutions:
 *      1. Do it in O(n^4) - no extra space (brute force)
 *      2. DO it in O(n^3 * log(n)) - no extra space.
 *      3. DO it in O(n^2) with O(n) extra space.
 */
// 454. 4Sum II (Medium)
// https://leetcode.com/problems/4sum-ii/
public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                m.put(sum, m.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                count += m.getOrDefault(-sum, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSum2 fs2 = new FourSum2();
        System.out.println(fs2.fourSumCount(new int[]{1,2}, new int[]{-2, -1},
                new int[]{-1, 2}, new int[]{0,2}));

        System.out.println(fs2.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
    }
}
