package com.specflare.algohut.leetcode.arrays;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to
 * its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel a
 * round the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique
 */
// https://leetcode.com/problems/gas-station/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumTanks = 0;
        int total = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int tank = gas[i] - cost[i];
            total += tank;

            if (sumTanks >= 0) {
                sumTanks += tank; // we accumulate.
            } else {
                sumTanks = tank; // we reset and start from here, and return i.
                start = i;
            }
        }

        return (total >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        GasStation gs = new GasStation();
        System.out.println(gs.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
