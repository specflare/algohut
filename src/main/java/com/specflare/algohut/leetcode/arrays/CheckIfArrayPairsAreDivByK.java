package com.specflare.algohut.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivByK {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
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
