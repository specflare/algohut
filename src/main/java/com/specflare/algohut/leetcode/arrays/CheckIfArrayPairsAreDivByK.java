package com.specflare.algohut.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers arr of even length n and an integer k.
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 * Return True If you can find a way to do that or False otherwise.
 */

// 1497. Check If Array Pairs Are Divisible by k (Medium)
// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
public class CheckIfArrayPairsAreDivByK {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // key = number, val = number of occurrences.
        for (int value : arr) {
            int num = ((value % k) + k) % k;
            int compl = (k - num) % k;

            if (map.containsKey(compl)) {
                int numOccur = map.get(compl) - 1;
                if (0 == numOccur) {
                    map.remove(compl);
                } else {
                    map.put(compl, numOccur);
                }
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        CheckIfArrayPairsAreDivByK p = new CheckIfArrayPairsAreDivByK();
        System.out.println(p.canArrange(new int[] {1,2,3,4,5,10,6,7,8,9}, 5));

        System.out.println(p.canArrange(new int[] {1,2,3,4,5,6}, 7));
        System.out.println(p.canArrange(new int[] {1,2,3,4,5,6}, 10));

        System.out.println(p.canArrange(new int[] {-10, 10}, 2));
        System.out.println(p.canArrange(new int[] {-1,1,-2,2,-3,3,-4,4}, 3));

        System.out.println(p.canArrange(new int[] {-4,-7,5,2,9,1,10,4,-8,-3}, 3));
    }
}
