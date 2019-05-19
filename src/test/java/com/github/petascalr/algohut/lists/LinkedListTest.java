package com.github.petascalr.algohut.lists;

import com.github.petascalr.algohut.algos.LinkedListAlgos;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LinkedListTest {
    private Random rand = new Random();

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

    @Test
    public void insertAfterTest() {
        int size = 10;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            list.addLast(i);
        }

        Integer key = 13;
        list.insertAfter(key, 6);

        Assert.assertEquals(list.countNodes(), size + 1);

        LinkedList.Node prev = list.find(6);
        Assert.assertEquals(prev.getNext().getData(), key);
    }
}
