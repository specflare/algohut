package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;

import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer
 * such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Solution: monotonic stack of decreasing temperatures
 * If T[i] > T[i - 1] => result[i] = 1;
 * else push (T[i], i) on a stack, until we get a new temperature that is bigger than top of stack.
 *
 * If the weather keeps decreasing, then the first warmer day for the first day is the first warmer
 * day for every day in the decreasing sequence! So once we find the first warmer day, we can find
 * the first warmer day for the whole sequence.
 */

// 739. Daily Temperatures (Medium)
// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    // Input: temperatures = [73,74,75,71,69,72,76,73]
    // Output:               [ 1, 1, 4, 2, 1, 1, 0, 0]
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> tempsStack = new Stack<>();
        tempsStack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[i - 1]) {
                while (!tempsStack.isEmpty()) {
                    int top = tempsStack.peek();
                    if (temperatures[top] < temperatures[i]) {
                        result[top] = i - top;
                        tempsStack.pop();
                    } else break;
                }
            }
            tempsStack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Util.printArray(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}), 20);
    }
}
