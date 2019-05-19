package com.github.petascalr.algohut.lists;

import com.github.petascalr.algohut.algos.LinkedListAlgos;
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

    @Test
    public void mergePointSuccessTest() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.addLast(4);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);

        list2.addLast(10);
        list2.addLast(8);
        list2.getLast().setNext(list1.getFirst().getNext().getNext().getNext());

        Assert.assertEquals(1, LinkedListAlgos.computeMergePoint(list1, list2).getData());
    }

    @Test
    public void mergePointFailTest() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.addLast(4);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);

        list2.addLast(10);
        list2.addLast(8);
        list2.addLast(3);
        list2.addLast(2);
        list2.addLast(1);

        Assert.assertNull(LinkedListAlgos.computeMergePoint(list1, list2));
    }
}
