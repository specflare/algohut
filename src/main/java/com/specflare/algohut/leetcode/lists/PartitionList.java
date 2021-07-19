package com.specflare.algohut.leetcode.lists;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before
 * nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Solution: you need to reconstruct the 2 lists and link them at the end.
 *      Lemuto partition does not work because it changes the relative order of the texts.
 */

// 86. Partition List (Medium)
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

    // Lemuto partitioning: does not preserve relative ordering of elements.
    public ListNode partitionNoNodeSwap(ListNode head, int x) {
        ListNode slow = head;

        for (ListNode curr = head; curr != null; curr = curr.next) {
            System.out.println("List: " + head.toString());
            System.out.println("slow: " + slow.toString());
            if (curr.val < x) {
                // swap slow and curr's values
                int temp = slow.val;
                slow.val = curr.val;
                curr.val = temp;

                slow = slow.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
//        System.out.println(pl.partition(ListNode.fromArray(new int[] {1,4,3,2,5,2}), 3).toString());
        System.out.println(pl.partitionNoNodeSwap(ListNode.fromArray(new int[] {1,4,3,2,5,2}), 3).toString());

//        System.out.println(pl.partition(ListNode.fromArray(new int[] {1,3,2}), 2).toString());
//        System.out.println(pl.partitionNoNodeSwap(ListNode.fromArray(new int[] {1,3,2}), 2).toString());
//
//        System.out.println(pl.partition(ListNode.fromArray(new int[] {2,1}), 2).toString());
//        System.out.println(pl.partition(ListNode.fromArray(new int[] {2}), 2).toString());
//
//        ListNode result = pl.partition(ListNode.fromArray(new int[] {}), 2);
//        if (null != result) {
//            System.out.println(result.toString());
//        }
    }
}
