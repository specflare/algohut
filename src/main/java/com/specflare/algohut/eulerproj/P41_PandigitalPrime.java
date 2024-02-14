package com.specflare.algohut.eulerproj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * We shall say that an
 * n-digit number is pandigital if it makes use of all the digits
 * 1 to n exactly once. For example,
 * 2143 is a 4-digit pandigital and is also prime.
 * What is the largest n-digit pandigital prime that exists?
 *
 *
 * Solution: Only pandigital numbers with 1, 4 and 7 digits can be prime,
 * because other numbers have the sum of their digits
 * divisible by 3, hence they are divisible by 3, hence not primes.
 */

// Largest Pandigital Prime
// https://projecteuler.net/problem=41
public class P41_PandigitalPrime {
    private static int largestPandigital = 987_654_321;

    private static boolean isPrime(int num, List<Integer> primes) {
        for (int prime : primes) {
            if (num % prime == 0) {
                return false;
            }
        }

        for (int i = primes.get(primes.size() - 1); i < Math.sqrt(largestPandigital); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPandigital(int num) {
        Set<Integer> digits = new HashSet<>();
        int numDigits = 0;
        while (num != 0) {
            int rightmostDigit = num % 10;

            if (rightmostDigit == 0) {
                return false;
            }

            num /= 10;
            digits.add(rightmostDigit);
            numDigits++;
        }


        for (int digit : digits) {
            if (digit > numDigits) {
                return false;
            }
        }
        return (numDigits == digits.size());
    }

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        primes.add(23);
        primes.add(29);

        int largestPandigitalPrime = 2;
        for (int i = largestPandigital; i >= 2; i -= 2) {
            if (isPandigital(i) && isPrime(i, primes)) {
                largestPandigitalPrime = i;
                break;
            }
        }

        System.out.println("largestPandigitalPrime = " + largestPandigitalPrime);
    }
}
