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

package com.specflare.algohut.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class BinarySearchTreeTest {
    Random rand = new Random();

    @Test
    public void basicTest() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int elem = rand.nextInt(10000);
            bt.insert(elem);
            list.add(elem);
        }

        for (Integer i : list) {
            Assert.assertTrue(bt.contains(i));
        }
    }

    @Test
    public void InOrderTest() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bt.insert(rand.nextInt(10000));
        }

        bt.visit( BinaryTree.VisitOrder.INORDER, list::add);

        // now the elems should be in ascending order in list.
        for (int i = 1; i < list.size(); i++) {
            Assert.assertTrue(list.get(i).compareTo(list.get(i - 1)) > 0);
        }
    }
}
