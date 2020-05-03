/*
 * MIT License
 *
 * Copyright (c) 2019 Liviu Gheorghisan <petascalr@gmail.com>
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

package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.trees.*;

public class BinaryTreeAlgos {

    private BinaryTreeAlgos(){}
    /**
     * A node X is the common ancestor if key1 is contained inside the left subtree of X, and key2 is contained inside the right subtree of X, assuming key1 < key2
     * This implementation variant assumes that both keys are present in the tree.
     * @param key1 first key
     * @param key2 second key
     * @param <T> Comparable key type (e.g. Integer)
     * @return reference to the common ancestor or null if not found.
     */
    public static <T extends Comparable<T>> BinaryTree.Node findLCA(BinaryTree.Node localRoot, T key1, T key2) {

        if (localRoot == null) {
            return null;
        }

        if (localRoot.data.equals(key1) || localRoot.data.equals(key2)) {
            return localRoot;
        }

        BinaryTree.Node left = findLCA(localRoot.left, key1, key2);
        BinaryTree.Node right = findLCA(localRoot.right, key1, key2);

        if (left != null && right != null) {
            return localRoot;
        }

        if (left != null) return left;

        return right;
    }

    /**
     * Summary:
     *  Solution 1: Traverse the tree level by level (easy): O(n^2) time complexity.
     *  Solution 2:
     */
    public static <T extends Comparable<T>> void SpiralTraversal(BinaryTree.Node root) {

    }

    public static <T extends Comparable<T>> void TopDownTraversal(BinaryTree.Node root) {

    }

    public static <T extends Comparable<T>> void BottomUpTraversal(BinaryTree.Node root) {

    }
}
