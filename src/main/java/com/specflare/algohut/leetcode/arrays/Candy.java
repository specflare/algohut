package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;
import java.util.Arrays;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 */
// 135. Candy (Hard)
// https://leetcode.com/problems/candy/description/
public class Candy {
    // accepted solution!
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        left[0] = right[right.length - 1] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        for (int i = 0; i < left.length; i++) {
            System.out.println(left[i] + " " + right[i]);
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

    // brute force, not accepted! (Time Limit Exceeded)
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
