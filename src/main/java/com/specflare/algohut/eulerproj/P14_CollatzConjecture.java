package com.specflare.algohut.eulerproj;

import java.util.*;

// https://projecteuler.net/problem=14
// Problem 14: Longest Collatz sequence

/**
 * The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class P14_CollatzConjecture {
    // find the collatz number with the biggest number of hops
    static void maxCollatz(long limit) {
        Map<Long, Integer> collatz = new HashMap<>(); // key = startNum, val=numHops.

        collatz.put(1L, 1);
        collatz.put(2L, 2);

        int maxHops = 2;
        long numWithMaxHops = 2;
        for (long i = 3; i <= limit; i++ ) {
            long currNum = i;
            int currHops = 1;

            while (currNum > 1) {
                if (currNum % 2 == 0) {
                    currNum /= 2;
                } else {
                    currNum = currNum * 3 + 1;
                }

                if (collatz.containsKey(currNum)) {
                    currHops += collatz.get(currNum);
                    break;
                }

                currHops++;
            }

            collatz.put(i, currHops);

            if (currHops > maxHops) {
                maxHops = currHops;
                numWithMaxHops = i;
            }
        }

        System.out.println("Number " + numWithMaxHops + " had " + maxHops + " hops!");
     }

    public static void main(String[] args) {
        maxCollatz(1_000_000);
    }
}
