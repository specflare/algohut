package com.specflare.algohut.leetcode.math;

public class Pow {
    public double myPow(double x, int n) {
        if (n > 0)
            return myPow_p(x, n);

        return 1.0 / myPow_p(x, -n);
    }

    private double myPow_p(double x, int n) {
        if (0 == n) {
            return 1;
        }

        if (1 == n) {
            return x;
        }

        double p = myPow(x, n / 2);

        if (n % 2 == 0) {
            return p * p;
        }

        return p * p * x;
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
