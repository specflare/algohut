package com.specflare.algohut.leetcode.trees;

// https://www.programcreek.com/2014/07/leetcode-largest-bst-subtree-java/
// https://leetcode.com/problems/largest-bst-subtree/
public class LargestBSTSubtree {
    private static class SubtreeData {
        int minVal, maxVal;
        int size;
        boolean isBST;

        public SubtreeData() {
            minVal = Integer.MAX_VALUE;
            maxVal = Integer.MIN_VALUE;
            size = 0;
            isBST = false;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        SubtreeData result = largestBSTSubtree_rec(root);
        return result.size;
    }

    private SubtreeData largestBSTSubtree_rec(TreeNode node) {
        SubtreeData curr = new SubtreeData();
        if (null == node) {
            curr.isBST = true;
            return curr;
        }

        SubtreeData left = largestBSTSubtree_rec(node.left);
        SubtreeData right = largestBSTSubtree_rec(node.right);

        curr.minVal = Math.min(node.val, left.minVal);
        curr.maxVal = Math.max(node.val, right.maxVal);

        if (left.isBST && right.isBST && left.maxVal < node.val && right.minVal > node.val) {
            curr.isBST = true;
            curr.size = left.size + right.size + 1;
        } else {
            curr.isBST = false;
            curr.size = Math.max(left.size, right.size);
        }

        return curr;
    }

    public static void main(String[] args) {
        LargestBSTSubtree lbs = new LargestBSTSubtree();
        TreeNode root1 =
            new TreeNode(60,
                new TreeNode(55,
                    new TreeNode(45), null),
                new TreeNode(70,
                        new TreeNode(65),
                        new TreeNode(80))
                );
        System.out.println(root1.toString());
        System.out.println(lbs.largestBSTSubtree(root1));
        System.out.println("\n-------------------\n");
        TreeNode root2 = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(4));
        System.out.println(root2.toString());
        System.out.println(lbs.largestBSTSubtree(root2));
    }
}
