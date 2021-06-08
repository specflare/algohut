package com.specflare.algohut.algos.combinatorics;

import java.util.Arrays;

public class Combinations {
    private static void generate_r(int[] data, int N, int P, int K) {
        if (K == P) {
            System.out.println(Arrays.toString(data));
            return;
        }

        int start = K > 0 ? data[K - 1] + 1 : 0;
        for (int i = start; i < N; i++) {
            data[K] = i;
            generate_r(data, N, P, K + 1);
        }
    }

    public static void generate(int N, int P) {
        int[] data = new int[P];
        generate_r(data, N, P, 0);
    }

    public static void main(String[] args) {
        int N = 4;
        int P = 2;
        generate(N, P); // combinations of N taken P.
    }
}
