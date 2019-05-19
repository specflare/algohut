package com.github.petascalr.algohut.trees;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    /**
     * Inserts a new key in the BST.
     * @param what Data to be inserted.
     * @return true if data is inserted, or false if data is already present in the BST.
     */
    public boolean insert(T what) {
        if (null == root) {
            root = new Node(what);
            return true;
        }

        Node parent = root;
        Node current = root;
        boolean isLeftChild = true;

        while (null != current) {
            if (what.compareTo(current.getData()) == 0) {
                return false;
            }

            parent = current;
            if (what.compareTo(current.getData()) < 0) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }
        }

        if (isLeftChild) {
            parent.setLeft(new Node(what));
        } else {
            parent.setRight(new Node(what));
        }

        return true;
    }
}
