package com.github.petascalr.algohut.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LinkedListTest {
    Random rand = new Random();

    @Test
    public void addFirstTest() {
        int size = 1000;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            list.addFirst(rand.nextInt(99999));
        }

        Assert.assertEquals(size, list.countNodes());
    }

    @Test
    public void addLastTest() {
        int size = 1000;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            list.addLast(rand.nextInt(99999));
        }

        Assert.assertEquals(size, list.countNodes());
    }

    @Test
    public void containsTest() {
        int size = 1;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            list.addLast(rand.nextInt(99999));
        }

        Integer key = 9998999;
        list.addLast(key);

        for (int i = 0; i < size; i++) {
            list.addLast(rand.nextInt(99999));
        }

        Assert.assertTrue(list.contains(key));
    }
}
