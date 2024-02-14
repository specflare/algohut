package com.specflare.algohut.leetcode.lists;

import java.util.Stack;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end,
 * should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */

// https://leetcode.com/problems/reverse-nodes-in-k-group/
// 25. Reverse Nodes in k-Group (Hard)
public class ReverseNodesInKGroups {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (k == 1) {
//            return head;
//        }
//
//        int nodeCount = 0;
//        for (ListNode curr = head; curr != null; curr = curr.next) {
//            nodeCount++;
//        }
//
//        int numGroups = nodeCount / k;
//        int remainingNodes = nodeCount % k;
//
//        for (int group = 0; group < numGroups; group++) {
//            ListNode groupStart = null;
//            ListNode groupCurr;
//
//            while (head != null) {
//                groupCurr.next = head;
//                groupCurr = groupStart.next;
//            }
//        }
//    }
//
//
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (k == 1) {
//            return head;
//        }
//
//        Stack<ListNode> st = new Stack<>();
//        ListNode newHead = new ListNode();
//        ListNode curr = new ListNode();
//        newHead.next = curr;
//        while (head != null) {
//            ListNode oldHead = head;
//            for (int i = 0; i < k && head != null; i++) {
//                st.push(head);
//                head = head.next;
//            }
//
//            // now we have k elements
//            if (st.size() == k) {
//                ListNode kCurr = new ListNode();
//                ListNode kStart = kCurr;
//                while (!st.empty()) {
//                    kCurr.next = st.pop();
//                    kCurr = kCurr.next;
//                }
//                curr.next = kStart.next;
//                curr = kCurr;
//            } else {
//
//            }
//        }
//
//        return res.next;
//    }
//
//    public ListNode reverseLL(ListNode start) {
//        if (start == null ) {
//            return null;
//        }
//
//        ListNode revN1 = reverseLL(start.next);
//        if (revN1 != null) {
//            revN1.next = start;
//        }
//    }
//
//    public static void main(String[] args) {
//        ReverseNodesInKGroups p = new ReverseNodesInKGroups();
//
//        // should print 2, 1, 4, 3, 5
//        System.out.println(p.reverseKGroup(ListNode.fromArray(new int[] {1,2,3,4,5}), 2));
//    }
}
