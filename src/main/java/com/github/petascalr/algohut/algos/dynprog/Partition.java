package com.github.petascalr.algohut.algos.dynprog;

// Given a list of integer numbers, find if it can be divided into 2 subsets with equal sum.

import java.util.Arrays;

public class Partition {

    // Steps. We compute total sum of elems.
    //      If odd, then the problem does not have a solution
    //      If even, then we might have a solution, iff we can find some elements in vec whose sum is totalSum/2.

    public static boolean partition_rec(int[] vec) {
        int totalSum = Arrays.stream(vec).sum();
        if (1 == (totalSum % 2)) {
            return false;
        }

        return part_rec(vec, vec.length, totalSum / 2);
    }

    private static boolean part_rec(int[] vec, int n, int sum) {
        if (0 == sum) {
            return true;
        }

        // we either include vec[n - 1] in the sum or not. we evaluate both cases.
        return part_rec(vec, n - 1, sum) ||
                part_rec(vec, n - 1, sum - vec[n - 1]);
    }
}
