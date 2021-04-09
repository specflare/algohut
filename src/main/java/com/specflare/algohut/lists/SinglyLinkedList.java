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

package com.specflare.algohut.lists;

import java.util.function.Consumer;

public class SinglyLinkedList<T> {
    public class Node {
        public Node next;
        public T data;

        Node(T what) {
            next = null;
            data = what;
        }
    }

    public Node first;

    public SinglyLinkedList() {
        this.first = null;
    }

    public SinglyLinkedList(Node first) {
        this.first = first;
    }

    public void fromArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    public void add(T what) {
        Node newNode = new Node(what);
        if (null != first) {
            newNode.next = first;
        }

        first = newNode;
    }

    public boolean insertAfter(T what, T after) {
        Node afterNode = find(after);

        if (null == afterNode) {
            return false;
        }

        Node newNode = new Node(what);
        newNode.next = afterNode.next;
        afterNode.next = newNode;

        return true;
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public boolean deleteKey(T what) {
        if (isEmpty()) {
            return false;
        }

        Node curr = first;
        Node prev = null;
        while (null != curr) {
            if (curr.equals(what)) {
                // we found the node, just re-link everything
                if (null != prev) {
                    prev.next = curr.next;
                }

                return true;
            }

            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    public boolean deleteFirst() {
        if (null == first) {
            return false;
        }

        first = first.next;
        return true;
    }

    public Node find(T what) {
        for (Node curr = first; curr != null; curr = curr.next) {
            if (curr.data.equals(what)) {
                return curr;
            }
        }

        return null;
    }

    public void foreach(Consumer<T> consume) {
        for (Node curr = first; curr != null; curr = curr.next) {
            consume.accept(curr.data);
        }
    }

    public int countNodes() {
        int count = 0;
        for (Node curr = first; curr != null; curr = curr.next, count++);
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        foreach(elem -> {
            sb.append(elem);
            sb.append(", ");
        });

        sb.append("]");

        return sb.toString();
    }
}