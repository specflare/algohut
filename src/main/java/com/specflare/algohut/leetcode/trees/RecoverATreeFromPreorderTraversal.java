package com.specflare.algohut.leetcode.trees;

import java.util.Stack;

/**
 * We run a preorder depth-first search (DFS) on the root of a binary tree.
 * At each node in this traversal, we output D dashes (where D is the depth of this node),
 * then we output the value of this node.  If the depth of a node is D,
 * the depth of its immediate child is D + 1.  The depth of the root node is 0.
 * If a node has only one child, that child is guaranteed to be the left child.
 * Given the output traversal of this traversal, recover the tree and return its root.
 *
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 */

public class RecoverATreeFromPreorderTraversal {
    // Input: traversal = "1-2--3--4-5--6--7"
    // Output: [1,2,5,3,4,6,7]
    public static TreeNode recoverFromPreorder(String traversal) {
        int pos = 0;
        Stack<TreeNode> stack = new Stack<>();

        while (pos < traversal.length()) {
            DepthValueIndex token = eatDepthValueIndex(traversal, pos);

            if (token == null) {
                break;
            }
            pos = token.index;
            TreeNode newNode = new TreeNode(token.value);

            if (stack.isEmpty()) {
                stack.push(newNode);
                continue;
            }

            // left child, next level
            if (stack.size() == token.depth) {
                // left child of top of stack
                stack.peek().left = newNode;
                stack.push(newNode);
                continue;
            }

            while (stack.size() > token.depth) {
                stack.pop();
            }

            stack.peek().right = newNode;
            stack.push(newNode);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek(); // should have only 1 elem here, the root.
    }

    private static DepthValueIndex eatDepthValueIndex(String traversal, int start) {
        if (start == traversal.length()) {
            return null;
        }

        int index = start;
        int depth = 0;
        int value = 0;

        for(; index < traversal.length(); index++) {
            if (traversal.charAt(index) == '-') {
                depth++;
            } else if (traversal.charAt(index) >= '0' && traversal.charAt(index) <= '9') {
                int nextDash = traversal.indexOf("-", index);
                if (-1 == nextDash) {
                    nextDash = traversal.length();
                }
                String strVal = traversal.substring(index, nextDash);
                value = Integer.parseInt(strVal);
                index = nextDash;
                break;
            }
        }

        return new DepthValueIndex(value, depth, index);
    }

    static class DepthValueIndex {
        public int value;
        public int depth;
        public int index;
        DepthValueIndex(int v, int d, int i) {
            value = v;
            depth = d;
            index = i;
        }

        @Override
        public String toString() { return String.format("D=%d, V=%d, I=%d", depth, value, index); }
    }

    public static void main(String[] args) {
        System.out.println(recoverFromPreorder("1-2--3--4-5--6--7").toString());
        System.out.println(recoverFromPreorder("1-2--3---4-5--6---7").toString());
        System.out.println(recoverFromPreorder("1-401--349---90--88").toString());
        System.out.println(recoverFromPreorder("999999999").toString());
        System.out.println(recoverFromPreorder("1").toString());
        System.out.println(recoverFromPreorder("1-2--4--5-3--6--7").toString());
    }
}
