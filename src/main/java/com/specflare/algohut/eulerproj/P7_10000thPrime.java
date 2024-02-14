package com.specflare.algohut.eulerproj;

import java.util.ArrayList;
import java.util.List;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, 13
 * we can see that the 6th prime is 13.
 * What is the 10,001st prime number?
 */

// https://projecteuler.net/problem=7
public class P7_10000thPrime {
    private static boolean isPrime(long num, List<Long> primes) {
        for (Long prime : primes) {
            if (num % prime == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Long> primes = new ArrayList<>();
        primes.add(2L);
        primes.add(3L);
        primes.add(5L);
        primes.add(7L);
        primes.add(11L);
        primes.add(13L);

        Long lastPrime = primes.get(primes.size() - 1);
        for (long i = lastPrime; primes.size() != 10_001; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }

        System.out.println("Number of primes computed: " + primes.size());
        System.out.println("Primes: " + primes);
    }
}
