/*
 * MIT License
 *
 * Copyright (c) 2021 Liviu Gheorghisan <specflare@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.specflare.algohut.algos;

import com.specflare.algohut.lists.*;

public class SinglyLinkedListAlgos {

    private SinglyLinkedListAlgos(){}

    /**
     * Computes the merge point between 2 lists (The list looks like 'Y').
     * Conditions:
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
    public static SinglyLinkedList.Node computeMergePoint(SinglyLinkedList list1, SinglyLinkedList list2) {

        int count1 = list1.countNodes();
        int count2 = list2.countNodes();
        int numCommonNodes = Math.abs(count1 - count2);

        SinglyLinkedList.Node currLonger;
        SinglyLinkedList.Node currShorter;

        if (count1 > count2) {
            currLonger = list1.first;
            currShorter = list2.first;
        } else {
            currLonger = list2.first;
            currShorter = list1.first;
        }

        while (null != currLonger && numCommonNodes > 0) {
            currLonger = currLonger.next;
            numCommonNodes--;
        }

        // Now both lists have an equal number of remaining nodes.
        while (null != currLonger && null != currShorter) {
            if (currLonger.data.equals(currShorter.data)) {
                return currLonger;
            }

            currLonger = currLonger.next;
            currShorter = currShorter.next;
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
    public static <T extends Comparable<T>> SinglyLinkedList<T>.Node sortedMerge(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T>.Node curr1 = list1.first;
        SinglyLinkedList<T>.Node curr2 = list2.first;
        SinglyLinkedList<T>.Node curr = null;
        SinglyLinkedList<T>.Node newFirst = null;

        while (null != curr1 && null != curr2) {
            SinglyLinkedList<T>.Node next;

            if (curr1.data.compareTo(curr2.data) < 0) {
                next = curr1;
                curr1 = curr1.next;
            } else if (curr1.data.compareTo(curr2.data) > 0) {
                next = curr2;
                curr2 = curr2.next;
            } else {
                next = curr1;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }

            // this only happens at first iteration
            if (null == newFirst) {
                newFirst = next;
            } else {
                // from 2nd iteration onwards
                curr.next = next;
            }
            curr = next;
        }

        if (null != curr) {
            if (null == curr1) {
                curr.next = curr2;
            } else {
                curr.next = curr1;
            }
        }

        return newFirst;
    }
}
