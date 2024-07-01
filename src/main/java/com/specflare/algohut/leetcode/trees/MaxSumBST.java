package com.specflare.algohut.leetcode.trees;

/**
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also
 * a Binary Search Tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

// 1373. Maximum Sum BST in Binary Tree (Hard)
public class MaxSumBST {
    private static class SubtreeData {
        int minVal, maxVal;
        int maxSum;
        boolean isBST;

        public SubtreeData() {
            minVal = Integer.MAX_VALUE;
            maxVal = Integer.MIN_VALUE;
            maxSum = 0;
            isBST = false;
        }
    }

    private int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        maxSumBSTSubtree_rec(root);
        return Math.max(0, maxSum);
    }

    private SubtreeData maxSumBSTSubtree_rec(TreeNode node) {
        SubtreeData curr = new SubtreeData();
        if (null == node) {
            curr.isBST = true;
            return curr;
        }

        SubtreeData left = maxSumBSTSubtree_rec(node.left);
        SubtreeData right = maxSumBSTSubtree_rec(node.right);

        curr.minVal = Math.min(node.val, left.minVal);
        curr.maxVal = Math.max(node.val, right.maxVal);

        if (left.isBST && right.isBST && left.maxVal < node.val && right.minVal > node.val) {
            curr.isBST = true;
            curr.maxSum = left.maxSum + right.maxSum + node.val;
            maxSum = Math.max(maxSum, curr.maxSum);
        } else {
            curr.isBST = false;
            curr.maxSum = Math.max(left.maxSum, right.maxSum);
        }

        return curr;
    }

    public static void main(String[] args) {
        MaxSumBST msb = new MaxSumBST();
        TreeNode root1 = TreeNode.fromLevelOrder(new Integer[]{1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6});
        System.out.println(root1);
        System.out.printf("maxSumBST = %d\n---\n", msb.maxSumBST(root1));

        TreeNode root2 = TreeNode.fromLevelOrder(new Integer[]{4, 3, null, 1, 2});
        System.out.println(root2);
        System.out.printf("maxSumBST = %d\n---\n", msb.maxSumBST(root2));

        TreeNode root3 = TreeNode.fromLevelOrder(new Integer[]{-4, -2, -5});
        System.out.println(root3);
        System.out.printf("maxSumBST = %d\n---\n", msb.maxSumBST(root3));

        {
            // test #4
            TreeNode root4 = TreeNode.fromLevelOrder(new Integer[]{4, 8, null, 6, 1, 9, null, -5, 4, null, null, null, -3, null, 10});
            System.out.println(root4);
            System.out.printf("maxSumBST = %d\n---\n", msb.maxSumBST(root4));
        }
    }
}
