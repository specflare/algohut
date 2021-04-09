package com.github.petascalr.algohut.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class SplayTreeTest {
    Random rand = new Random();

    @Test
    public void basicTest() {
        SplayTree<Integer> st = new SplayTree<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int elem = rand.nextInt(10000);
            st.insert(elem);
            list.add(elem);
        }

        for (Integer i : list) {
            Assert.assertTrue(st.lookup(i));
        }
    }

    @Test
    public void displayTest() {
        SplayTree<Integer> st = new SplayTree<>();

        for (int i = 0; i < 20; i++) {
            int elem = rand.nextInt(100);
            st.insert(elem);
        }

        st.display();
    }

    @Test
    public void InOrderTest() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bt.insert(rand.nextInt(10000));
        }

        bt.visit( BinaryTree.VisitOrder.INORDER, list::add);

        // now the elems should be in ascending order in list.
        for (int i = 1; i < list.size(); i++) {
            Assert.assertTrue(list.get(i).compareTo(list.get(i - 1)) > 0);
        }
    }
}
