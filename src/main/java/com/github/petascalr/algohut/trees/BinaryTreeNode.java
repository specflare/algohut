package com.github.petascalr.algohut.trees;

public class BinaryTreeNode<T extends Comparable<T>> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T what) {
        this.data = what;
        left = right = null;
    }

    public BinaryTreeNode(T what, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = what;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return ((left == null) && (right == null));
    }

    public boolean contains(T key) {
        if (key.equals(data)) {
            return true;
        }

        if (null != left && key.compareTo(data) < 0) {
            return left.contains(key);
        }

        if (null != right && key.compareTo(data) > 0) {
            return right.contains(key);
        }

        return false;
    }
}
