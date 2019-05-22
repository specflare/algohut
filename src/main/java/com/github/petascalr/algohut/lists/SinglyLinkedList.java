package com.github.petascalr.algohut.lists;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.function.Consumer;

@NoArgsConstructor
public class SinglyLinkedList<T> {
    @NoArgsConstructor
    @AllArgsConstructor
    public class Node {

        @Getter @Setter
        Node next;

        @Getter @Setter
        T data;

        Node(T what) {
            next = null;
            data = what;
        }
    }

    @Getter
    private Node first;

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
            newNode.setNext(first);
        }

        first = newNode;
    }

    public boolean insertAfter(T what, T after) {
        Node afterNode = find(after);

        if (null == afterNode) {
            return false;
        }

        Node newNode = new Node(what);
        newNode.setNext(afterNode.getNext());
        afterNode.setNext(newNode);

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
                    prev.setNext(curr.getNext());
                }

                return true;
            }

            prev = curr;
            curr = curr.getNext();
        }

        return false;
    }

    public boolean deleteFirst() {
        if (null == first) {
            return false;
        }

        first = first.getNext();
        return true;
    }

    public Node find(T what) {
        for (Node curr = first; curr != null; curr = curr.getNext()) {
            if (curr.getData().equals(what)) {
                return curr;
            }
        }

        return null;
    }

    public void foreach(Consumer<T> consume) {
        for (Node curr = first; curr != null; curr = curr.getNext()) {
            consume.accept(curr.getData());
        }
    }

    public int countNodes() {
        int count = 0;
        for (Node curr = first; curr != null; curr = curr.getNext(), count++);
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