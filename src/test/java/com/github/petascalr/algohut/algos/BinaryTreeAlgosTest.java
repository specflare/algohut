package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.trees.BinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeAlgosTest {
    @Test
    public void lowestCommonAncestorSuccessTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(7);
        bst.insert(15);

        bst.insert(12);
        bst.insert(11);

        Assert.assertEquals(10, BinaryTreeAlgos.findLCA(bst.getRoot(), 1, 11).getData());
        Assert.assertEquals(5, BinaryTreeAlgos.findLCA(bst.getRoot(), 4, 7).getData());
        Assert.assertEquals(3, BinaryTreeAlgos.findLCA(bst.getRoot(), 1, 4).getData());

        // Assert.assertEquals(3, BinaryTreeAlgos.findLCA(bst.getRoot(), 15, 45).getData());
    }
}
