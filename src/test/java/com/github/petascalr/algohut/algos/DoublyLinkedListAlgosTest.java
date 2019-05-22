package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.lists.DoublyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedListAlgosTest {
    @Test
    public void mergePointSuccessTest() {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

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
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

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
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

        list1.fromArray(new Integer[] {1, 3, 5, 7});
        list2.fromArray(new Integer[] {2, 4, 6, 7, 8, 10});

        // please note that this implementation destroys the original lists, because it does the computations in place: O(n) time, O(1) space.
        DoublyLinkedList<Integer>.Node first = LinkedListAlgos.sortedMerge(list1, list2);
        DoublyLinkedList<Integer> listResult = new DoublyLinkedList<>(first);
        Assert.assertEquals(9, listResult.countNodes());
    }
}
