package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.lists.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListAlgosTest {
//    @Test
//    public void mergePointSuccessTest() {
//        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
//        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
//
//        list1.add(4);
//        list1.add(6);
//        list1.add(7);
//        list1.add(1);
//        list1.add(3);
//        list1.add(5);
//
//        list2.add(10);
//        list2.add(8);
//
//        list2.getLast().setNext(list1.getFirst().getNext().getNext().getNext());
//
//        Assert.assertEquals(1, SinglyLinkedListAlgos.computeMergePoint(list1, list2).getData());
//    }

    @Test
    public void mergePointFailTest() {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();

        list1.add(4);
        list1.add(6);
        list1.add(7);
        list1.add(1);
        list1.add(3);
        list1.add(5);

        list2.add(10);
        list2.add(8);
        list2.add(3);
        list2.add(2);
        list2.add(1);

        Assert.assertNull(SinglyLinkedListAlgos.computeMergePoint(list1, list2));
    }

//    @Test
//    public void sortedMergeSuccessTest() {
//        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
//        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
//
//        list1.fromArray(new Integer[] {1, 3, 5, 7});
//        list2.fromArray(new Integer[] {2, 4, 6, 7, 8, 10});
//
//        // please note that this implementation destroys the original lists, because it does the computations in place: O(n) time, O(1) space.
//        SinglyLinkedList<Integer>.Node first = SinglyLinkedListAlgos.sortedMerge(list1, list2);
//        SinglyLinkedList<Integer> listResult = new SinglyLinkedList<>(first);
//        Assert.assertEquals(9, listResult.countNodes());
//    }
}
