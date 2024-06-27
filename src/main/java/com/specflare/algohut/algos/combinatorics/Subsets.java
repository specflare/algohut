package com.specflare.algohut.algos.combinatorics;

import java.util.Stack;

// Generate all the valid subsets of a given set.
// e.g.: S = [1, 2, 3], we have 2^3 = 8 subsets:
// Subsets: [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]
public class Subsets {
    private static void genSubsets_rec(Stack<Integer> sol, int N) {
        System.out.println(sol);
        for (int i = sol.size(); i < N; i++) {
            if (!sol.empty() && i <= sol.peek())
                continue;

            sol.push(i);
            genSubsets_rec(sol, N);
            sol.pop();
        }
    }

    public static void main(String[] args) {
        genSubsets_rec(new Stack<>(), 3);
    }
}
