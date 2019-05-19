package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.lists.*;

public class LinkedListAlgos {
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
    public static LinkedList.Node computeMergePoint(LinkedList list1, LinkedList list2) {

        int count1 = list1.countNodes();
        int count2 = list2.countNodes();
        int numCommonNodes = Math.abs(count1 - count2);

        LinkedList.Node currLonger;
        LinkedList.Node currShorter;

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
}
