package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */

// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        return topKFrequent_Heap(nums, k);
    }

    private int[] topKFrequent_Heap(int[] arr, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : arr) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> x : freqs.entrySet()) {
            pq.offer(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements tk = new TopKFrequentElements();
        Util.printArray(tk.topKFrequent(new int[] {1,1,1,2,2,3}, 2), 100);
        Util.printArray(tk.topKFrequent(new int[] {1}, 1), 100);
        Util.printArray(tk.topKFrequent(new int[] {1, 2, 2,3,3,3,4,5,5,5,5,5}, 3), 100);
    }
}
