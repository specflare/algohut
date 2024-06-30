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
        return prettyPrint();
    }

    public String prettyPrint() {
        StringBuffer sb = new StringBuffer();
        print_r(this, 0, sb);
        return sb.toString();
    }

    private void print_r(TreeNode node, int level, StringBuffer sb) {
        if (node != null) {
            print_r(node.right, level + 1, sb);
            sb.append("\t".repeat(Math.max(0, level)));
            sb.append(node.val);
            sb.append("\n");
            print_r(node.left, level + 1, sb);
        }
    }
}
