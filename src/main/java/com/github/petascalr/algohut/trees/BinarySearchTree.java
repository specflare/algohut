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

package com.github.petascalr.algohut.trees;

/**
 * Implements a generic binary search tree.
 * For reference: https://en.wikipedia.org/wiki/Binary_search_tree
 * @param <T> Generic data type
 */
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
            if (what.compareTo(current.data) == 0) {
                return false;
            }

            parent = current;
            if (what.compareTo(current.data) < 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }

        if (isLeftChild) {
            parent.left = new Node(what);
        } else {
            parent.right = new Node(what);
        }

        return true;
    }
}
