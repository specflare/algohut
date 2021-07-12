package com.specflare.algohut.leetcode.arrays;

import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer
 * such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Solution: monotonic stack of decreasing temperatures
 * If T[i] > T[i - 1] => result[i] = 1;
 * else push (T[i], i) on a stack, until we get a new temperature that is bigger than top of stack.
 */

// 739. Daily Temperatures
// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    class Elem {
        public int temp;
        public int index;

        public Elem(int t, int i) {
            this.temp = t;
            this.index = i;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Elem> tempsStack = new Stack<Elem>();
        tempsStack.push(new Elem(temperatures[0], 0));

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[i - 1]) {
                while (!tempsStack.isEmpty()) {
                    Elem elem = tempsStack.peek();
                    if (elem.temp < temperatures[i]) {
                        result[elem.index] = i - elem.index;
                        tempsStack.pop();
                    } else break;
                }

                tempsStack.push(new Elem(temperatures[i], i));
            } else {
                tempsStack.push(new Elem(temperatures[i], i));
            }
        }

        return result;
    }
}
