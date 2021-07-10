package com.specflare.algohut.numerics;

import java.util.HashMap;
import java.util.Map;
public class Factorization {
    public static Map<Integer, Integer> factorize(int n) {
        Map<Integer, Integer> factors = new HashMap<>();

        while (n % 2 == 0) {
            factors.put(2, factors.getOrDefault(2, 0) + 1);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }

        if (n > 2) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }

        return factors;
    }

    public static void main(String []args) {
        int n = 1988;
        Map<Integer, Integer> factors = factorize(n);
        for (Map.Entry<Integer, Integer> factor : factors.entrySet()) {
            System.out.print(factor.getValue() > 1
                            ? String.format("%d^%d * ", factor.getKey(), factor.getValue())
                            : String.format("%d * ", factor.getKey()));
        }
    }
}