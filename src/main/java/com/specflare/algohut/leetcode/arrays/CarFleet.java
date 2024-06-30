package com.specflare.algohut.leetcode.arrays;

import java.util.*;

// 853. Car Fleet (Medium)
// https://leetcode.com/problems/car-fleet/

/**
 * Solution:
 *  1. Sort cars by their positions. First car is the closest to destination.
 *  2. Compute the 'time to finish' for each car.
 */
public class CarFleet {
    static class Car {
        public int pos, speed;
        public Car (int p, int s) {
            this.pos = p;
            this.speed = s;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (c1, c2) -> c2.pos - c1.pos);

        float lastMax = (float)(target - cars[0].pos) / cars[0].speed;
        int count = 1;
        for (int i = 1; i < position.length; i++) {
            float currTimeToFinish = (float)(target - cars[i].pos) / cars[i].speed;
            if (currTimeToFinish > lastMax) {
                lastMax = currTimeToFinish;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CarFleet cf = new CarFleet();

        // prints 3
        System.out.println(cf.carFleet(12,
                new int[] {10,8,0,5,3},
                new int[] {2,4,1,1,3}));

        // prints 1
        System.out.println(cf.carFleet(10,
                new int[] {3},
                new int[] {3}));

        // prints 1
        System.out.println(cf.carFleet(100,
                new int[] {0,2,4},
                new int[] {4,2,1}));
    }
}
