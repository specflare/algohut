package com.specflare.algohut.leetcode.arrays;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to
 * its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas[] and cost[], return the starting gas station's index if you can travel
 * around the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique
 */
// 134. Gas Station (Medium)
// https://leetcode.com/problems/gas-station/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr = 0;
        int total_gas = 0, total_cost = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            total_gas += gas[i];
            total_cost += cost[i];
        }

        if (total_gas < total_cost)
            return -1;

        for (int i = 0; i < gas.length; i++) {
            curr += gas[i] - cost[i];
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        GasStation gs = new GasStation();
        System.out.println(gs.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
