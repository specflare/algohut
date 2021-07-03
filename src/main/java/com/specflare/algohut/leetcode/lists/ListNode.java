package com.specflare.algohut.leetcode.lists;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof ListNode)) {
            return false;
        }

        ListNode c1 = this, c2 = (ListNode) rhs;
        for (; null != c1 && null != c2; c1 = c1.next, c2 = c2.next) {
            if (c1.val != c2.val) {
                return false;
            }
        }

        return c1 == c2; // both should be null, if they are the same length.
    }

    public static ListNode fromArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }

        ListNode res = new ListNode(arr[0]);
        ListNode curr = res;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ListNode curr = this; curr != null; curr = curr.next) {
            sb.append(String.format("%d, ", curr.val));
        }
        sb.append("]");
        return sb.toString();
    }
}
