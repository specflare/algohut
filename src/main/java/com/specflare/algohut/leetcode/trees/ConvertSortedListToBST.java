package com.specflare.algohut.leetcode.trees;

import com.specflare.algohut.leetcode.lists.ListNode;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 */

// 109. Convert Sorted List to Binary Search Tree (Medium)
// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class ConvertSortedListToBST {
    ListNode currNode = null;
    public TreeNode sortedListToBST(ListNode head) {
        int len = getListLength(head);
        if (0 == len) {
            return null;
        }

        this.currNode = head;
        return constructBSTBottomUp(0, len -1);
    }

    private static int getListLength(ListNode head) {
        int len = 0;
        while (null != head) {
            head = head.next;
            len++;
        }
        return len;
    }

    private TreeNode constructBSTBottomUp(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode leftNode = constructBSTBottomUp(left,  mid - 1);
        TreeNode root = new TreeNode(currNode.val);
        currNode = currNode.next;
        TreeNode rightNode = constructBSTBottomUp(mid + 1,  right);

        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedListToBST conv = new ConvertSortedListToBST();
        System.out.println(conv.sortedListToBST(ListNode.fromArray(new int[] {1,2,3,4,5,6,7,8,9,10})).toString());
        System.out.println("\n\n" + conv.sortedListToBST(ListNode.fromArray(new int[] {1})).toString());
        System.out.println("\n\n" + conv.sortedListToBST(ListNode.fromArray(new int[] {1, 2})).toString());
        System.out.println("\n\n" + conv.sortedListToBST(ListNode.fromArray(new int[] {1, 2, 3})).toString());
    }
}
