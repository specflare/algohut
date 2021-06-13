package com.specflare.algohut.leetcode.math;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
// Tags: Median, Queue, PriorityQueue, Stream
// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianOfDataStream {
    private final PriorityQueue<Integer> upperHalf, lowerHalf;

    public MedianOfDataStream() {
        upperHalf = new PriorityQueue<>(); // MinHeap
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap
    }

    /**
     * How this works?
     * We have 1 MinHeap that contains the upper half of the elements
     * We also have 1 MaxHeap that contains the lowerHalf of the elements
     * When a new elem arrives, we add it to either the lower half or the upper half. If their sizes get unbalanced,
     *  we move one element from one side to the other, so that their size difference is at most 1.
     */
    public void addNum(int num) {
        if (lowerHalf.size() == 0 && upperHalf.size() == 0) {
            lowerHalf.add(num);
            return;
        }

        if (lowerHalf.size() == upperHalf.size()) {
            if (num < upperHalf.peek()) {
                lowerHalf.add(num);
            } else {
                upperHalf.add(num);
            }
        } else if (lowerHalf.size() < upperHalf.size()) {
            if (num < upperHalf.peek()) {
                lowerHalf.add(num);
            } else {
                // move one elem from upperHalf to lowerHalf
                lowerHalf.add(upperHalf.poll());
                upperHalf.add(num);
            }
        } else { // lowerHalf.size() > upperHalf.size()
            if (num > lowerHalf.peek()) {
                upperHalf.add(num);
            } else {
                // move one elem from lower half to upper half
                upperHalf.add(lowerHalf.poll());
                lowerHalf.add(num);
            }
        }
    }

    public double findMedian() {
        if (lowerHalf.size() == 0 && upperHalf.size() == 0) {
            return 0;
        }

        if (lowerHalf.size() == 0 || lowerHalf.size() < upperHalf.size()) {
            return upperHalf.peek();
        }

        if (upperHalf.size() == 0 || lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        }

        // equal sizes, so median is the average of the heap peaks.
        return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianOfDataStream mods = new MedianOfDataStream();
        for (int i = 0; i < 3; i++) {
            int X = Math.abs(ThreadLocalRandom.current().nextInt()) % 100;
            System.out.print(X + " ");
            mods.addNum(X);
        }

        System.out.println("\nMedian is: " + mods.findMedian());
    }
}
