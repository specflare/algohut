package com.specflare.algohut.leetcode.trees;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every
 * node never differs by more than one.
 */

// 108. Convert Sorted Array to Binary Search Tree (Easy)
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (0 == nums.length) {
            return null;
        }

        return computeBST(nums, 0, nums.length - 1);
    }

    private TreeNode computeBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = computeBST(nums, left, mid - 1);
        root.right = computeBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST c = new ConvertSortedArrayToBST();
        System.out.println(c.sortedArrayToBST(new int[] {1,2,3,4,5,6,7,8,9}));
        System.out.println("\n\n" + c.sortedArrayToBST(new int[] {1}));
        System.out.println("\n\n" + c.sortedArrayToBST(new int[] {1, 2}));
        System.out.println("\n\n" + c.sortedArrayToBST(new int[] {1, 2, 3}));
    }
}
