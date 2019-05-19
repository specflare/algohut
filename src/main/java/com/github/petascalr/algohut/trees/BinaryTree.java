package com.github.petascalr.algohut.trees;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

@NoArgsConstructor
public abstract class BinaryTree<T extends Comparable<T> > {
    /**
     * Represents a Node in the BST.
     */
    @AllArgsConstructor
    @NoArgsConstructor
    public class Node {

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

        boolean isLeaf() {
            return ((left == null) && (right == null));
        }

        public boolean contains(T key) {
            if (key.equals(data)) {
                return true;
            }

            if (key.compareTo(data) < 0) {
                return left.contains(key);
            }

            if (key.compareTo(data) > 0) {
                return right.contains(key);
            }

            return false;
        }
    }

    public enum VisitOrder {
        PREORDER,
        INORDER,
        POSTORDER
    }

    @Getter
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

    public boolean contains(T key) {
        return root.contains(key);
    }

//    private boolean containsImpl(Node localRoot, T key) {
//        if (null == localRoot) {
//            return false;
//        }
//
//        if (key.compareTo(localRoot.getData()) < 0) {
//            return containsImpl(localRoot.getLeft(), key);
//        }
//
//        if (key.compareTo(localRoot.getData()) > 0) {
//            return containsImpl(localRoot.getRight(), key);
//        }
//
//        return true;
//    }

    public void visit(VisitOrder order, Consumer<T> consume) {
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
            visitInOrder(localRoot.left, consume);
            consume.accept(localRoot.getData());
            visitInOrder(localRoot.right, consume);
        }
    }

    private void visitPostOrder(Node localRoot, Consumer<T> consume) {
        if (null != localRoot) {
            visitPostOrder(localRoot.left, consume);
            visitPostOrder(localRoot.right, consume);
            consume.accept(localRoot.getData());
        }
    }

    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof BinaryTree)) {
            return false;
        }

        BinaryTree bt = (BinaryTree) rhs;
        return equalsImpl(root, bt.getRoot());
    }

    private boolean equalsImpl(Node lhs, Node rhs) {
        if (null == lhs && null == rhs) {
            return true;
        }

        return false;
    }
}
