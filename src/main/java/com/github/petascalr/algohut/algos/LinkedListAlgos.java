package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.lists.*;

public class LinkedListAlgos {

    private LinkedListAlgos(){}

    /**
     * Computes the merge point between 2 lists.
     * Conditions:
     *      - We assume the linked lists are singly linked lists (for doubly linked lists this is easy).
     *      - The 2 lists have no cycles.
     *      - The 2 lists may contain any type of data.
     *      - The 2 lists are not altered inside this function.
     *
     * Solution:
     *  1. Count the nodes in list1
     *  2. Count the nodes in list2
     *  3. Compute the number of common nodes to both lists like this: D = abs(c1 - c2);
     *  4. Traverse the bigger list from the beginning D nodes ahead. From this point onwards both lists have an equal
     *      number of nodes remaining till the end.
     *
     *  5. Traverse both lists in parallel and, at each step, compare their current node.
     *  6. If we have an equality, this is the merge point. If we reach the end without an equality, return null.
     * @param list1
     * @param list2
     * @return The merge node if exists, null otherwise
     */
    public static DoublyLinkedList.Node computeMergePoint(DoublyLinkedList list1, DoublyLinkedList list2) {

        int count1 = list1.countNodes();
        int count2 = list2.countNodes();
        int numCommonNodes = Math.abs(count1 - count2);

        DoublyLinkedList.Node currLonger;
        DoublyLinkedList.Node currShorter;

        if (count1 > count2) {
            currLonger = list1.getFirst();
            currShorter = list2.getFirst();
        } else {
            currLonger = list2.getFirst();
            currShorter = list1.getFirst();
        }

        while (null != currLonger && numCommonNodes > 0) {
            currLonger = currLonger.getNext();
            numCommonNodes--;
        }

        // Now both lists have an equal number of remaining nodes.
        while (null != currLonger && null != currShorter) {
            if (currLonger.getData().equals(currShorter.getData())) {
                return currLonger;
            }

            currLonger = currLonger.getNext();
            currShorter = currShorter.getNext();
        }

        return null;
    }

    /**
     * Merges the 2 lists into a sorted list.
     * This is an IN PLACE implementation, in O(n) time, and O(1) space.
     * This implementation destroys the input lists.
     * @param list1 sorted list1
     * @param list2 sorted list2
     * @return
     */
    public static <T extends Comparable<T>> DoublyLinkedList<T>.Node sortedMerge(DoublyLinkedList<T> list1, DoublyLinkedList<T> list2) {
        DoublyLinkedList<T>.Node curr1 = list1.getFirst();
        DoublyLinkedList<T>.Node curr2 = list2.getFirst();
        DoublyLinkedList<T>.Node curr = null;
        DoublyLinkedList<T>.Node newFirst = null;

        while (null != curr1 && null != curr2) {
            DoublyLinkedList<T>.Node next;

            if (curr1.getData().compareTo(curr2.getData()) < 0) {
                next = curr1;
                curr1 = curr1.getNext();
            } else if (curr1.getData().compareTo(curr2.getData()) > 0) {
                next = curr2;
                curr2 = curr2.getNext();
            } else {
                next = curr1;
                curr1 = curr1.getNext();
                curr2 = curr2.getNext();
            }

            // this only happens at first iteration
            if (null == newFirst) {
                newFirst = next;
                curr = next;
            } else {
                // from 2nd iteration onwards
                curr.setNext(next);
                curr = next;
            }
        }

        if (null != curr) {
            if (null == curr1) {
                curr.setNext(curr2);
            } else {
                curr.setNext(curr1);
            }
        }

        return newFirst;
    }
}
