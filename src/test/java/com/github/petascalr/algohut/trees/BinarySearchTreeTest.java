package com.github.petascalr.algohut.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class BinarySearchTreeTest {
    Random rand = new Random();

    @Test
    public void BasicTest() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Integer elem = rand.nextInt(10000);
            bt.insert(elem);
            list.add(elem);
        }

        for (Integer i : list) {
            Assert.assertTrue(bt.contains(i));
        }
    }

    @Test
    public void InOrderTest() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Integer elem = rand.nextInt(10000);
            bt.insert(elem);
        }

        bt.visit( BinaryTree.VisitOrder.INORDER, list::add);

        // now the elems should be in ascending order in list.
        for (int i = 1; i < list.size(); i++) {
            Assert.assertTrue(list.get(i).compareTo(list.get(i - 1)) > 0);
        }
    }
}
