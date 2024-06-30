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

package com.specflare.algohut.algos;

import com.specflare.algohut.trees.*;

public class BinaryTreeAlgos {

    private BinaryTreeAlgos(){}
    /**
     * A node X is the common ancestor if key1 is contained inside the left subtree of X,
     * and key2 is contained inside the right subtree of X, assuming key1 < key2
     * This implementation variant assumes that both keys are present in the tree.
     * @param key1 first key
     * @param key2 second key
     * @param <T> Comparable key type (e.g. Integer)
     * @return reference to the common ancestor or null if not found.
     */
    public static <T extends Comparable<T>> BinaryTreeNode<T> findLCA(BinaryTreeNode<T> localRoot, T key1, T key2) {

        if (localRoot == null) {
            return null;
        }

        // we search for either key in the whole tree, and return either node.
        if (localRoot.data.equals(key1) || localRoot.data.equals(key2)) {
            return localRoot;
        }

        // bottom-up traversal.
        BinaryTreeNode<T> left = findLCA(localRoot.left, key1, key2);
        BinaryTreeNode<T> right = findLCA(localRoot.right, key1, key2);

        // if this node contains one key on the left, and the other on the right, return it
        if (left != null && right != null) {
            return localRoot;
        }

        // both keys on the left
        if (left != null) return left;

        // both keys on the right.
        return right;
    }

    /**
     * Summary:
     *  Solution 1: Traverse the tree level by level (easy): O(n^2) time complexity.
     *  Solution 2:
     */
    public static <T extends Comparable<T>> void SpiralTraversal(BinaryTreeNode<T> root) {

    }

    public static <T extends Comparable<T>> void TopDownTraversal(BinaryTreeNode<T> root) {

    }

    public static <T extends Comparable<T>> void BottomUpTraversal(BinaryTreeNode<T> root) {

    }
}
