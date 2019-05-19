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
    }

    public enum VisitOrder {
        PREORDER,
        INORDER,
        POSTORDER
    }

    Node root;

    /**
     * Deletes a leaf node from the BST.
     * If key is not found in the tree, nothing happens.
     * @param key Key to be deleted
     */
    public void deleteLeaf(T key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild;
        while (null != current) {
            parent = current;
            isLeftChild = true;
            if (key.compareTo(current.getData()) < 0) {
                current = current.getLeft();
                isLeftChild = true;
            } else if (key.compareTo(current.getData()) > 0) {
                current = current.getRight();
                isLeftChild = false;
            } else {
                // we found the node, we just delete the parent's corresponding child.
                if (isLeftChild) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
        }
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
