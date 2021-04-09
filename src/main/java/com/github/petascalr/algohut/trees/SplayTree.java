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

package com.github.petascalr.algohut.trees;

public class SplayTree<T extends Comparable<T>> {
    static class SplayNode<T extends Comparable<T>> {
        public T data;
        public SplayNode<T> left;
        public SplayNode<T> right;
        public SplayNode<T> parent;

        public SplayNode(T key) {
            this.data = key;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public SplayNode(T key, SplayNode<T> left, SplayNode<T> right, SplayNode<T> parent) {
            this.data = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public SplayNode(T key, SplayNode<T> parent) {
            this.data = key;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }

        public boolean isLeftChild () {
            if (null == parent) {
                return false;
            }

            return (parent.left == this);
        }
    }

    public SplayTree() {
        this.root = null;
    }

    SplayNode<T> root;

    public SplayNode<T> insert(T key) {
        if (null == root) {
            root = new SplayNode<>(key, null);
            return root;
        }

        return insert_r(key, root, null, false);
    }

    private SplayNode<T> insert_r(T key, SplayNode<T> localRoot, SplayNode<T> parent, boolean isLeftChild) {
        if (null == localRoot) {
            SplayNode<T> newNode = new SplayNode<>(key, parent);
            if (isLeftChild) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }

            return newNode;
        }

        if (key.equals(localRoot.data)) {
            return localRoot;
        }

        if (key.compareTo(localRoot.data) < 0) {
            return insert_r(key, localRoot.left, localRoot, true);
        } else {
            return insert_r(key, localRoot.right, localRoot, false);
        }
    }

    public boolean lookup(T key) {
        return lookup_r(key, root);
    }

    public boolean lookup_r(T key, SplayNode<T> localRoot) {
        if (null == localRoot) {
            return false;
        }

        if (localRoot.data.equals(key)) {
            return true;
        }

        if (key.compareTo(localRoot.data) < 0) {
            return lookup_r(key, localRoot.left);
        }

        return lookup_r(key, localRoot.right);
    }

    private void rotateLeft(SplayNode<T> node) {

    }

    private void rotateRight(SplayNode<T> node) {

        // We have the following nodes: PP, P, X, R
        node.parent.left = node.right;
        node.right.parent = node.parent;

        node.right = node.parent;

        if (null != node.parent.parent) {
            if (node.parent.isLeftChild()) {
                node.parent.parent.left = node;
            } else {
                node.parent.parent.right = node;
            }
        }

        node.parent = node.parent.parent;
        node.parent.parent = node;
    }

    private void splay(SplayNode<T> node) {
        while (null != node.parent) {
            if (node.isLeftChild()) {

            }
        }
    }

    public void display() {
        display_r(root, 0);
    }

    private void display_r(SplayNode<T> localRoot, int level) {
        if (null != localRoot) {
            display_r(localRoot.right, level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("\t\t");
            }

            String prefix;
            if (null != localRoot.parent) {
                if (localRoot.isLeftChild()) {
                    prefix = "\\";
                } else
                {
                    prefix = "/";
                }
            } else {
                prefix = "*";
            }

            System.out.println(String.format("%s %s", prefix, localRoot.data.toString()));

            display_r(localRoot.left, level + 1);
        }
    }
}
