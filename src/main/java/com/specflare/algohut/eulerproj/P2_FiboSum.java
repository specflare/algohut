package com.specflare.algohut.eulerproj;

// https://projecteuler.net/problem=2
public class P2_FiboSum {
    public static void main(String[] args) {
        int a = 1, b = 2, c = a + b;
        int s = 2; // first even fibo number
        do {
            c = a + b;
            if (c >= 4_000_000) {
                break;
            }

            a = b;
            b = c;

            System.out.print(c + " ");
            if (c % 2 == 0) {
                s += c;
            }
        } while (true);

        System.out.println();
        System.out.println("Sum = " + s);
    }
}
