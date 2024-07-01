package com.specflare.algohut.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

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

    public static TreeNode fromLevelOrder(Integer[] levelOrderArr) {
        if (levelOrderArr.length == 0 || levelOrderArr[0] == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrderArr[0]);
        queue.add(root);
        int it = 1;

        while (!queue.isEmpty() && it < levelOrderArr.length) {
            TreeNode top = queue.poll();

            if (null == top) {
                continue;
            }

            TreeNode left = null;
            if (levelOrderArr[it] != null) {
                left = new TreeNode(levelOrderArr[it]);
            }
            it++;

            TreeNode right = null;
            if (levelOrderArr[it] != null) {
                right = new TreeNode(levelOrderArr[it]);
            }
            it++;

            top.left = left;
            top.right = right;
            queue.add(left);
            queue.add(right);
        }

        return root;
    }
}
