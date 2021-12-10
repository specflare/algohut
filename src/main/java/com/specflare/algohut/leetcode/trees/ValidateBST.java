package com.specflare.algohut.leetcode.trees;

// https://leetcode.com/problems/validate-binary-search-tree/
// 98. Validate Binary Search Tree (Medium)
public class ValidateBST {
    // leftmost ancestor is minimum
    // rightmost ancestor is maximum
    public boolean isValidBST(TreeNode node) {
        return isValidBST_r(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST_r(TreeNode node, int minRange, int maxRange) {
        if (null == node) {
            return true;
        }

        if (node.val < minRange || node.val > maxRange) {
            return false;
        }

        boolean leftOK = true;
        if (null != node.left) {
            leftOK =  node.left.val < node.val && isValidBST_r(node.left, minRange, node.val);
        }

        boolean rightOK = true;
        if (null != node.right) {
            rightOK = node.val < node.right.val && isValidBST_r(node.right, node.val, maxRange);
        }

        return leftOK && rightOK;
    }
}
