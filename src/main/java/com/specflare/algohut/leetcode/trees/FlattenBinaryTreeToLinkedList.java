package com.specflare.algohut.leetcode.trees;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * - The "linked list" should use the same TreeNode class where the right child pointer points
 *      to the next node in the list and the left child pointer is always null.
 * - The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 */
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// 114. Flatten Binary Tree to Linked List (Medium)
// Status: Working
public class FlattenBinaryTreeToLinkedList {
    TreeNode curr = null;
    public void flatten(TreeNode root) {
        if (null != root) {
            curr = root;
            TreeNode oldLeft = root.left;
            TreeNode oldRight = root.right;

            root.left = null;

            curr.right = oldLeft;
            flatten(oldLeft);

            curr.right = oldRight;
            flatten(oldRight);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1
                , new TreeNode(2
                    , new TreeNode(3)
                    , new TreeNode(4)
                )
                , new TreeNode(5
                    , null
                    , new TreeNode(6)
                )
        );

        FlattenBinaryTreeToLinkedList fbtll = new FlattenBinaryTreeToLinkedList();
        fbtll.flatten(root);
        System.out.println(root.prettyPrint());
    }
}
