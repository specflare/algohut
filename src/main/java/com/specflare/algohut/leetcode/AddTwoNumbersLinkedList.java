package com.specflare.algohut.leetcode;

import com.specflare.algohut.leetcode.util.ListNode;

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
// reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbersLinkedList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(), curr = first;

        ListNode c1 = l1, c2 = l2;
        int carry = 0;
        while (c1 != null || c2 != null) {
            int v1 = (c1 != null) ? c1.val : 0;
            int v2 = (c2 != null) ? c2.val : 0;

            int sum = v1 + v2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        first = first.next; // because the first node is empty, just skip it.
        return first;
    }
}
