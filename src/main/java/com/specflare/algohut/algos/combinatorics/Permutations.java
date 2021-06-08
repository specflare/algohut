package com.specflare.algohut.algos.combinatorics;

import java.util.Stack;

public class Permutations {
    public static void bt_rec_permutations(int N, Stack<Integer> sol) { // WORKING
        if (sol.size() == N) {
            System.out.println(sol);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (sol.contains(i))
                continue;

            sol.push(i);
            bt_rec_permutations(N, sol);
            sol.pop();
        }
    }

    public static void bt_rec_permutations2(int[] stack, int K, int N) { // WORKING
        if (K == N) {
            for (int i = 0; i < K; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            // find first i so that i is different from all elems in the stack up to K-1.
            boolean valid = true;
            for (int j = 0; j < K; j++) {
                if (stack[j] == i) {
                    valid = false;
                }
            }

            if (!valid) {
                continue;
            }

            stack[K] = i;
            bt_rec_permutations2(stack, K + 1, N);
        }
    }

    public static void main(String[] args) {
        // genPermLiviu_rec(5, new Stack<>());
        bt_rec_permutations2(new int[3], 0, 3);
    }
}
