package com.specflare.algohut.leetcode.trees;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
// https://leetcode.com/problems/symmetric-tree/description/
// 101. Symmetric Tree (Easy)
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isSym_r(root.left, root.right);
    }

    private boolean isSym_r(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }

        if (null == p || null == q) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSym_r(p.left, q.right) && isSym_r(p.right, q.left);
    }
}
