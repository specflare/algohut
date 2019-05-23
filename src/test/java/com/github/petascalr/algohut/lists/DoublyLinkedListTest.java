/*
 * MIT License
 *
 * Copyright (c) 2019 Liviu Ioan <petascalr@gmail.com>
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

package com.github.petascalr.algohut.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class DoublyLinkedListTest {
    private Random rand = new Random();

    @Test
    public void addFirstTest() {
        int size = 1000;
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < size; i++) {
            list.addFirst(rand.nextInt(99999));
        }

        Assert.assertEquals(size, list.countNodes());
    }

    @Test
    public void addLastTest() {
        int size = 1000;
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < size; i++) {
            list.addLast(rand.nextInt(99999));
        }

        Assert.assertEquals(size, list.countNodes());
    }

    @Test
    public void containsTest() {
        int size = 1;
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < size; i++) {
            list.addLast(i);
        }

        Integer key = 13;
        list.insertAfter(key, 6);

        Assert.assertEquals(list.countNodes(), size + 1);

        DoublyLinkedList.Node prev = list.find(6);
        Assert.assertEquals(prev.getNext().getData(), key);
    }
}
