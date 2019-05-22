package com.github.petascalr.algohut.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class SinglyLinkedListTest {
    private Random rand = new Random();

    @Test
    public void addTest() {
        int size = 1000;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(99999));
        }

        Assert.assertEquals(size, list.countNodes());
    }

    @Test
    public void containsTest() {
        int size = 1;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(99999));
        }

        Integer key = 9998999;
        list.add(key);

        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(99999));
        }

        Assert.assertNotNull(list.find(key));
    }

    @Test
    public void insertAfterTest() {
        int size = 10;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        Integer key = 13;
        list.insertAfter(key, 6);

        Assert.assertEquals(list.countNodes(), size + 1);

        SinglyLinkedList.Node prev = list.find(6);
        Assert.assertEquals(prev.getNext().getData(), key);
    }
}
