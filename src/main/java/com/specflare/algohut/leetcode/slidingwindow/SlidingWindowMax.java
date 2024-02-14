package com.specflare.algohut.leetcode.slidingwindow;

import com.specflare.algohut.Util;

import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-maximum/description/
// 239. Sliding Window Maximum (Hard)
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int r = 0;

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max2) {
                // keep the last 2 max numbers.
                max1 = max2;
                max2 = nums[i];
            }
        }

        result[r++] = max2;

        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= max2) {
                if (nums[i] > nums[i - k]) {
                    max1 = max2;
                    max2 = nums[i];
                    result[r++] = max2;
                } else {

                }
            } else {
                // 5 . . . . 4
            }
        }

        return result;
    }

    // not accepted, Time Limit Exceeded!
    public int[] maxSlidingWindow_pq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int[] result = new int[nums.length - k + 1];
        int r = 0;

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        // System.out.println("pq = " + pq);

        for (int i = k; i < nums.length; i++) {
            result[r++] = pq.peek();
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            // System.out.println("pq = " + pq);
        }
        result[r++] = pq.peek();

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMax p = new SlidingWindowMax();
        int[] res = p.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        Util.printArray(res, res.length);
    }
}
