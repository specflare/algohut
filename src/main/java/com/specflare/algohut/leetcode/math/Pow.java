package com.specflare.algohut.leetcode.math;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */

// https://leetcode.com/problems/powx-n/description/
// 50. Pow(x, n) (Medium)
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n < 0) {
            if (n % 2 == 0) {
                n = n / 2;
                n = -n;
                x = (1 / x) * (1 / x);
            } else {
                n = -n;
                x = 1 / x;
            }
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }

        return x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(34.00515 , -3));

        System.out.println(p.myPow(2 , 3));
        System.out.println(p.myPow(2 , -2));
        System.out.println(p.myPow(4 , 0));
        System.out.println(p.myPow(4 , -1));
        System.out.println(p.myPow(2 , -20));

        System.out.println(p.myPow(2 , -2147483648));
    }
}
