package com.specflare.algohut.algos.combinatorics;

import java.util.Arrays;

public class Arrangements {
    private static void generate_r(int[] data, int N, int P, int K) {
        if (K == P) {
            System.out.println(Arrays.toString(data));
            return;
        }

        for (int i = 0; i < N; i++) {
            data[K] = i;
            if (isValid(data, K)) {
                generate_r(data, N, P, K + 1);
            }
        }
    }

    public static boolean isValid(int[] data, int K) {
        for (int i = 0; i < K; i++) {
            if (data[K] == data[i])
                return false;
        }
        return true;
    }

    public static void generate(int N, int P) {
        int[] data = new int[P];
        generate_r(data, N, P, 0);
    }

    public static void main(String[] args) {
        int N = 4;
        int P = 2;
        generate(N, P); // Arrangements of N taken P.
    }
}
