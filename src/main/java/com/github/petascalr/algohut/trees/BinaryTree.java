package com.github.petascalr.algohut.trees;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

/**
 * Implements a generic binary search tree.
 * For reference: https://en.wikipedia.org/wiki/Binary_search_tree
 * @param <T> Generic data type
 */
@NoArgsConstructor
public abstract class BinaryTree<T extends Comparable<T> > {
    /**
     * Represents a Node in the BST.
     */
    @AllArgsConstructor
    @NoArgsConstructor
    class Node {

        @Getter @Setter
        private T data;

        @Getter @Setter
        private Node left;

        @Getter @Setter
        private Node right;

        Node(T what) {
            this.data = what;
            left = right = null;
        }

        public boolean isLeaf() {
            return ((left == null) && (right == null));
        }
    }

    public enum VisitOrder {
        PREORDER,
        INORDER,
        POSTORDER
    }

    Node root;

    /**
     * Deletes a leaf node from the BST.
     * If the key is found, but it is not a leaf, it is NOT deleted.
     * @param key Key to be deleted.
     * @return true if key is found (and it is a leaf), false otherwise.
     */
    public boolean deleteLeaf(T key) {
        Node current = root;
        Node parent = current;
        boolean isLeftChild = true;

        if (null == root) {
            return false;
        }

        while (null != current) {
            parent = current;

            if (key.compareTo(current.getData()) < 0) {
                current = current.getLeft();
                isLeftChild = true;
            } else if (key.compareTo(current.getData()) > 0) {
                current = current.getRight();
                isLeftChild = false;
            } else {
                // we found the node, we need to check if it's a leaf.
                if (current.isLeaf()) {
                    break;
                } else {
                    return false;
                }
            }
        }

        if (isLeftChild) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }

        return true;
    }

    public void visit(Consumer<T> consume, VisitOrder order) {
        switch (order) {
            case PREORDER:
                visitPreOrder(root, consume);
                break;
            case INORDER:
                visitInOrder(root, consume);
                break;
            case POSTORDER:
                visitPostOrder(root, consume);
                break;
            default:
                throw new IllegalArgumentException("Visit order is incorrectly specified.");
        }
    }

    private void visitPreOrder(Node localRoot, Consumer<T> consume) {
        if (null != localRoot) {
            consume.accept(localRoot.getData());
            visitPreOrder(localRoot.left, consume);
            visitPreOrder(localRoot.right, consume);
        }
    }

    private void visitInOrder(Node localRoot, Consumer<T> consume) {
        if (null != localRoot) {
            visitPreOrder(localRoot.left, consume);
            consume.accept(localRoot.getData());
            visitPreOrder(localRoot.right, consume);
        }
    }

    private void visitPostOrder(Node localRoot, Consumer<T> consume) {
        if (null != localRoot) {
            visitPreOrder(localRoot.left, consume);
            visitPreOrder(localRoot.right, consume);
            consume.accept(localRoot.getData());
        }
    }
}
