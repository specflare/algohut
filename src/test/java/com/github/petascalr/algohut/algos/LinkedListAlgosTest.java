package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.lists.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListAlgosTest {
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

    @Test
    public void sortedMergeSuccessTest() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.fromArray(new Integer[] {1, 3, 5, 7});
        list2.fromArray(new Integer[] {2, 4, 6, 7, 8, 10});

        // please note that this implementation destroys the original lists, because it does the computations in place: O(n) time, O(1) space.
        LinkedList<Integer>.Node first = LinkedListAlgos.sortedMerge(list1, list2);
        LinkedList<Integer> listResult = new LinkedList<>(first);
        Assert.assertEquals(9, listResult.countNodes());
    }
}
