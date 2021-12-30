package com.specflare.algohut.leetcode;

import com.specflare.algohut.Util;

import java.util.Arrays;

public class Candy {

    public int candy_bf(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        boolean done  = false;
        while(!done) {
            done = true;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    done = false;
                }
            }

            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    done = false;
                }
            }
        }

        Util.printArray(candies, candies.length);

        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        System.out.println(c.candy_bf(new int[] {1, 0, 2}));
        System.out.println(c.candy_bf(new int[] {1, 2, 2}));
    }
}
