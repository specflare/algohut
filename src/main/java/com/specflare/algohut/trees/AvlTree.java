package com.specflare.algohut.trees;

public class AvlTree {
    static class Node {
        int key, height;
        Node left, right;

        Node(int data) {
            key = data;
            height = 1;
        }
    }

    Node root;

    private static int height(Node n) {
        if (null == n) {
            return 0;
        }

        return n.height;
    }

    private static Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // return new root.
        return x;
    }

    private static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }
}
