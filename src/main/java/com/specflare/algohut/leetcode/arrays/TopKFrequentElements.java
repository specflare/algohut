package com.specflare.algohut.leetcode.arrays;

import com.specflare.algohut.Util;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */

// 347. Top K Frequent Elements (Medium)
// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        return topKFrequent_QuickSelect(nums, k);
    }

    private int[] topKFrequent_Heap(int[] arr, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : arr) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

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

    // -------------------------------------
    // Quick select solution from LeetCode
    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public int partition(int[] arr, Map<Integer, Integer> freqs, int left, int right, int pivot_index) {
        int pivot_frequency = freqs.get(arr[pivot_index]);
        // 1. move pivot to end
        swap(arr, pivot_index, right);
        int store_index = left;

        // 2. move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (freqs.get(arr[i]) < pivot_frequency) {
                swap(arr, store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(arr, store_index, right);
        return store_index;
    }

    public void quickselect(int[] arr, Map<Integer, Integer> freqs, int left, int right, int k_smallest) {
        // sort a list within left..right till kth less frequent element takes its place

        // base case: the list contains only one element
        if (left == right)
            return;

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // find the pivot position in a sorted list
        pivot_index = partition(arr, freqs, left, right, pivot_index);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        }

        if (k_smallest < pivot_index) {
            quickselect(arr, freqs, left, pivot_index - 1, k_smallest);
        } else {
            quickselect(arr, freqs, pivot_index + 1, right, k_smallest);
        }
    }

    public int[] topKFrequent_QuickSelect(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        // array of unique elements
        int[] unique = new int[freqs.size()];
        int i = 0;
        for (int num : freqs.keySet()) {
            unique[i++] = num;
        }

        quickselect(unique, freqs, 0, unique.length - 1, unique.length - k);
        return Arrays.copyOfRange(unique, unique.length - k, unique.length);
    }

    public static void main(String[] args) {
        TopKFrequentElements tk = new TopKFrequentElements();
//        Util.printArray(tk.topKFrequent(new int[] {1,1,1,2,2,3}, 2), 100);
//        Util.printArray(tk.topKFrequent(new int[] {1}, 1), 100);
        Util.printArray(tk.topKFrequent(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5}, 3), 100);
    }
}
