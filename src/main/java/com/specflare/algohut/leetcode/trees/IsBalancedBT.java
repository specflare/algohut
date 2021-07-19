package com.specflare.algohut.leetcode.trees;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Solution: a node is balanced if both its children are balanced and abs(h1 - h2) <= 1.
 */

// 110. Balanced Binary Tree (Easy)
// https://leetcode.com/problems/balanced-binary-tree/
public class IsBalancedBT {
    static class Result {
        public boolean balanced;
        public int height;

        public Result (boolean b, int h) {
            balanced = b;
            height = h;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBalanced_r(root, 0).balanced;
    }

    private Result isBalanced_r(TreeNode node, int level) {
        if (node == null) {
            return new Result(true, level);
        }

        Result left = isBalanced_r(node.left, level + 1);
        Result right = isBalanced_r(node.right, level + 1);

        int height = Math.max(left.height, right.height);
        if (left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1) {
            return new Result(true, height);
        }

        return new Result(false, height);
    }

    public static void main(String[] args) {
        IsBalancedBT bbt = new IsBalancedBT();
        TreeNode t = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, new TreeNode(4), new TreeNode(4)),
                        new TreeNode(3)),
                new TreeNode(2));

        System.out.println(t.toString());
        System.out.println(bbt.isBalanced(t));
    }
}
