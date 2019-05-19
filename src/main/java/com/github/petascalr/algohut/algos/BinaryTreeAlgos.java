package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.trees.*;

public class BinaryTreeAlgos {

    /**
     * A node X is the common ancestor if key1 is contained inside the left subtree of X, and key2 is contained inside the right subtree of X, assuming key1 < key2
     * @param key1 first key
     * @param key2 second key
     * @param <T> Comparable key type (e.g. Integer)
     * @return reference to the common ancestor or null if not found.
     */
    public static <T extends Comparable<T>> BinaryTree.Node getCommonAncestor(T key1, T key2) {

        if (key1.compareTo(key2) < 0) {

        }

        return null;
    }
}
