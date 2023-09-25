package com.specflare.algohut.eulerproj;

// https://projecteuler.net/problem=3
public class P3_LargestPrimeFactor {
    public static void main(String[] args) {
        long n = 600851475143L;

        long i = 2;
        long maxFactor = 1;

        while (i < 780_000L) {
            if (n % i == 0) {
                n /= i;
                maxFactor = Math.max(maxFactor, i);
                System.out.print(i + " ");

                if (i == n) {
                    break;
                }
            } else {
                i++;
            }
        }

        System.out.println();
        System.out.println("max factor: " + maxFactor);
    }
}
