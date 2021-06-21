package com.specflare.algohut.leetcode.lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

// Hard: https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < lists.length; i++) {
            if (null != lists[i]) {
                pq.add(lists[i]);
            }
        }

        ListNode newStart = null;
        ListNode curr = null;
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            ListNode newNode = new ListNode(n.val);

            if (null == newStart) {
                newStart = newNode;
                curr = newNode;
            } else {
                curr.next = newNode;
                curr = curr.next;
            }

            if (null != n.next) {
                pq.add(n.next);
            }
        }

        return newStart;
    }

    public static void main(String[] args) {
        MergeKSortedLists mksl = new MergeKSortedLists();
        System.out.println(
            mksl.mergeKLists(new ListNode[] {
                    ListNode.fromArray(new int[] {1,3,5,7}),
                    ListNode.fromArray(new int[] {2,4,6,8})
            })
        );

        System.out.println(
                mksl.mergeKLists(new ListNode[] {
                        ListNode.fromArray(new int[] {1,4,5}),
                        ListNode.fromArray(new int[] {1,3,4}),
                        ListNode.fromArray(new int[] {2,6})
                })
        );

        System.out.println(
                mksl.mergeKLists(new ListNode[] {
                        ListNode.fromArray(new int[] {1,4,5}), null
                })
        );

        System.out.println(
                mksl.mergeKLists(new ListNode[] {})
        );
    }
}
