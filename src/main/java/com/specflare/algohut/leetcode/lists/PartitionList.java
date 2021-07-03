package com.specflare.algohut.leetcode.lists;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before
 * nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
// https://leetcode.com/problems/partition-list/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (null == head) {
            return null;
        }

        ListNode start1 = null, curr1 = null, start2 = null, curr2 = null;

        while (null != head) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                if (null == start1) {
                    start1 = curr1 = head;
                } else {
                    curr1.next = head;
                    curr1 = curr1.next;
                }
            } else {
                if (null == start2) {
                    start2 = curr2 = head;
                } else {
                    curr2.next = head;
                    curr2 = curr2.next;
                }
            }
            head = next;
        }
        if (null == start1) {
            return start2;
        }
        curr1.next = start2;
        return start1;
    }

    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        System.out.println(pl.partition(ListNode.fromArray(new int[] {1,4,3,2,5,2}), 3).toString());
        System.out.println(pl.partition(ListNode.fromArray(new int[] {1,3,2}), 2).toString());
        System.out.println(pl.partition(ListNode.fromArray(new int[] {2,1}), 2).toString());
        System.out.println(pl.partition(ListNode.fromArray(new int[] {2}), 2).toString());

        ListNode result = pl.partition(ListNode.fromArray(new int[] {}), 2);
        if (null != result) {
            System.out.println(result.toString());
        }
    }
}
