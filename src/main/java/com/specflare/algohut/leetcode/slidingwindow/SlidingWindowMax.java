package com.specflare.algohut.leetcode.slidingwindow;

import com.specflare.algohut.Util;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Solution:
 * Keep a deque of numbers for each sliding window, such that the last element
 * int the deque is the max of the sliding window.
 */
// https://leetcode.com/problems/sliding-window-maximum/description/
// https://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
// 239. Sliding Window Maximum (Hard)
public class SlidingWindowMax {

    // n = 10, k = 3 => res = 8.

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]) {
                deque.removeFirst();
            }
            deque.addLast(i);
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.getFirst()];
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

        for (int i = k; i < nums.length; i++) {
            result[r++] = pq.peek();
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
        }
        result[r] = pq.peek();

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMax p = new SlidingWindowMax();
        int[] res = p.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        Util.printArray(res, res.length);
    }
}
