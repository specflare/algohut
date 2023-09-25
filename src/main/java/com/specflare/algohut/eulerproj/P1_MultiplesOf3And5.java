package com.specflare.algohut.eulerproj;

public class P1_MultiplesOf3And5 {
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
