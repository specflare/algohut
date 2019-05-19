package com.github.petascalr.algohut.lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@NoArgsConstructor
public class LinkedList<T> {

    @NoArgsConstructor
    @AllArgsConstructor
    public class Node {

        @Getter @Setter
        Node next;

        @Getter @Setter
        Node prev;

        @Getter @Setter
        T data;

        Node(T what) {
           next = null;
           prev = null;
           data = what;
        }
    }

    @Getter
    private Node first;

    @Getter
    private Node last;

    public void addFirst(T what) {
        Node newNode = new Node(what);
        if (null == first) {
            first = newNode;
            last = first;
        } else {
            newNode.setNext(first);
            first.setPrev(newNode);
            first = newNode;
        }
    }

    public void addLast(T what) {
        Node newNode = new Node(what);
        if (null == last) {
            last = newNode;
            first = last;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
            last = newNode;
        }
    }

    public boolean insertAfter(T what, T after) {
        Node afterNode = find(after);

        if (null == afterNode) {
            return false;
        }

        Node newNode = new Node(what);
        newNode.setPrev(afterNode);
        newNode.setNext(afterNode.getNext());

        afterNode.setNext(newNode);

        if (null != newNode.getNext()) {
            newNode.getNext().setPrev(newNode);
        }

        return true;
    }

    public boolean isEmpty() {
        return (this.first == null && this.last == null);
    }

    public boolean delete(T what) {
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

                if (null != curr.getNext()) {
                    curr.getNext().setPrev(prev);
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
        first.setPrev(null);
        return true;
    }

    public boolean deleteLast() {
        if (null == last) {
            return false;
        }

        last = last.getPrev();
        last.setNext(null);
        return true;
    }

    public boolean contains(T what) {
        for (Node curr = first; curr != null; curr = curr.getNext()) {
            if (curr.getData().equals(what)) {
                return true;
            }
        }

        return false;
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
