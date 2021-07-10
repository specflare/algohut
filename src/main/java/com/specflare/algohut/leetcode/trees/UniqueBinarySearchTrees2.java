package com.specflare.algohut.leetcode.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */

// 95. Unique Binary Search Trees II
// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }

        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees2 ubst = new UniqueBinarySearchTrees2();
        List<TreeNode> result = ubst.generateTrees(3);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
            System.out.println("-----");
        }
    }
}
