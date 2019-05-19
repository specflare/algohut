package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.trees.*;

public class BinaryTreeAlgos {

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

        if (localRoot.getData().equals(key1) || localRoot.getData().equals(key2)) {
            return localRoot;
        }

        BinaryTree.Node left = findLCA(localRoot.getLeft(), key1, key2);
        BinaryTree.Node right = findLCA(localRoot.getRight(), key1, key2);

        if (left != null && right != null) {
            return localRoot;
        }

        if (left != null) return left;

        return right;
    }
}
