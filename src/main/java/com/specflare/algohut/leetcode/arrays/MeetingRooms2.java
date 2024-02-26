package com.specflare.algohut.leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of start and end
 * times[[s1,e1], [s2,e2], ...] where (si < ei), find the minimum number of
 * conference rooms required.
 */

// https://aaronice.gitbook.io/lintcode/sweep-line/meeting-rooms-ii
// Meeting Rooms II (Medium)
public class MeetingRooms2 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        Queue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));

        int count = 0;
        for (Interval interval : intervals) {
            while (
                    !queue.isEmpty() && interval.start >= queue.peek().end
            ) queue.poll();

            queue.offer(interval);
            count = Math.max(count, queue.size());
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
