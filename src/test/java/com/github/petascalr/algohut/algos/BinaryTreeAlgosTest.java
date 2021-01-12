/*
 * MIT License
 *
 * Copyright (c) 2019 Liviu Gheorghisan <petascalr@gmail.com>
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

package com.github.petascalr.algohut.algos;

import com.github.petascalr.algohut.trees.BinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeAlgosTest {
    @Test
    public void lowestCommonAncestorSuccessTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(7);
        bst.insert(15);

        bst.insert(12);
        bst.insert(11);

        Assert.assertEquals(10, BinaryTreeAlgos.findLCA(bst.root, 1, 11).data.intValue());
        Assert.assertEquals(5, BinaryTreeAlgos.findLCA(bst.root, 4, 7).data.intValue());
        Assert.assertEquals(3, BinaryTreeAlgos.findLCA(bst.root, 1, 4).data.intValue());

        // Assert.assertEquals(3, BinaryTreeAlgos.findLCA(bst.root, 15, 45).data);
    }
}
