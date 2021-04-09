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

import com.specflare.algohut.lists.SinglyLinkedList;
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
//        list2.getLast().setNext(list1.getFirst().next.next.next);
//
//        Assert.assertEquals(1, SinglyLinkedListAlgos.computeMergePoint(list1, list2).data);
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
