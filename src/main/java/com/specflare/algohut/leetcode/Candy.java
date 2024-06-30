package com.specflare.algohut.leetcode;

import com.specflare.algohut.Util;

import java.util.Arrays;

// https://leetcode.com/problems/candy/
// 135. Candy (Hard)

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 */
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
