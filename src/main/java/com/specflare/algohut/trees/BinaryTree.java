/*
 * MIT License
 *
 * Copyright (c) 2021 Liviu Gheorghisan <specflare@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.specflare.algohut.trees;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T> > {
    public enum VisitOrder {
        PREORDER,
        INORDER,
        POSTORDER
    }

    public BinaryTreeNode<T> root;

    /**
     * Deletes a leaf node from the BST.
     * If the key is found, but it is not a leaf, it is NOT deleted.
     * @param key Key to be deleted.
     * @return true if key is found (and it is a leaf), false otherwise.
     */
    public boolean deleteLeaf(T key) {
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> parent = current;
        boolean isLeftChild = true;

        if (null == root) {
            return false;
        }

        while (null != current) {
            parent = current;

            if (key.compareTo(current.data) < 0) {
                current = current.left;
                isLeftChild = true;
            } else if (key.compareTo(current.data) > 0) {
                current = current.right;
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
            parent.left = null;
        } else {
            parent.right = null;
        }

        return true;
    }

    public boolean contains(T key) {
        return root.contains(key);
    }

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

    private void visitPreOrder(BinaryTreeNode<T> localRoot, Consumer<T> consume) {
        if (null != localRoot) {
            consume.accept(localRoot.data);
            visitPreOrder(localRoot.left, consume);
            visitPreOrder(localRoot.right, consume);
        }
    }

    private void visitInOrder(BinaryTreeNode<T> localRoot, Consumer<T> consume) {
        if (null != localRoot) {
            visitInOrder(localRoot.left, consume);
            consume.accept(localRoot.data);
            visitInOrder(localRoot.right, consume);
        }
    }

    private void visitPostOrder(BinaryTreeNode<T> localRoot, Consumer<T> consume) {
        if (null != localRoot) {
            visitPostOrder(localRoot.left, consume);
            visitPostOrder(localRoot.right, consume);
            consume.accept(localRoot.data);
        }
    }

//    @Override
//    public boolean equals(Object rhs) {
//        if (!(rhs instanceof BinaryTree)) {
//            return false;
//        }
//
//        BinaryTree<T> bt = (BinaryTree<T>) rhs;
//        return equalsImpl(root, bt.root);
//    }

    private boolean equalsImpl(BinaryTreeNode<T> lhs, BinaryTreeNode<T> rhs) {
        if (null == lhs && null == rhs) {
            return true;
        }

        return false;
    }
}
