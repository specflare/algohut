package com.specflare.algohut.algos.dp;

// Given a list of integer numbers, find if it can be divided into 2 subsets with equal sum.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Partition {

    // Steps. We compute total sum of elems.
    //      If odd, then the problem does not have a solution
    //      If even, then we might have a solution, iff we can find some elements in vec whose sum is totalSum/2.

    public static boolean partition_rec(int[] vec) {
        int totalSum = Arrays.stream(vec).sum();
        System.out.println("totalSum = " + totalSum);
        Map<Integer, Boolean> memo = new HashMap<>();
        if (1 == (totalSum % 2)) {
            return false;
        }

        return part_rec(vec, vec.length, totalSum / 2, memo);
    }

    // recursive solution with memoization.
    private static boolean part_rec(int[] vec, int n, int sum, Map<Integer, Boolean> memo) {
        int key = (n << 16) | (sum & 0xffff);

        if (0 == sum) {
            return true;
        }

        if (0 == n) {
            return false;
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // we either include vec[n - 1] in the sum or not. we evaluate both cases.
        boolean result = part_rec(vec, n - 1, sum, memo)
                || part_rec(vec, n - 1, sum - vec[n - 1], memo);

        memo.putIfAbsent(key, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partition_rec(new int[] {11,4,23,6}));
        System.out.println(partition_rec(new int[] {12,4,5,6,7,89,4,3,1,23,5,4,3,7,6,5,4,3,2,1,8}));
    }
}
