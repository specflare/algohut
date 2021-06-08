package com.specflare.algohut.leetcode.trees;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("{\"V\": \"%d\", \"L\": %s, \"R\": %s}", val, null != left ? left.toString() : null, null != right ? right.toString() : null);
    }
}
