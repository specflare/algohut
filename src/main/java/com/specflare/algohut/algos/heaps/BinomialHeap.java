package com.specflare.algohut.algos.heaps;

import java.util.Random;

/**
 * The main application of a Binomial Heap is to implement a priority Q.
 * A Binomial Heap is a collection of Binomial trees.
 * A Binomial Tree of order K can be constructed by taking 2 BTs of order k-1 and making one as leftmost child of the other.
 * A BT of order K has he following properties:
 *  - It has exactly 2^K nodes.
 *  - It has a depth of K.
 *  - It has a root node whose children are roots of binomial trees of orders k-1, k-2, k-3...2,1,0.
 *  - It has a number of nodes equal to  Comb(K, D), where D is the depth where we count the nodes, D = 0..K.
 *
 * A BH satisfies the BH properties:
 *  - Each BT in the BH obeys the min-heap property
 *  - There can be at most 1 BT for each order, including the 0 order.
 *  - A BH with n nodes consists of at most 1 + log(n) BTs.
 */
public class BinomialHeap {
    public static class Node {
        int data;
        int order;

        Node next;
        Node child;

        public Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
            this.order = 0;
        }

        @Override
        public String toString() {
            return String.format("D=%d, order=%d", data, order);
        }
    }

    private Node root;
    public BinomialHeap() {
        root = null;
    }

    public void add(int data) {
        if (null == root) {
            root = new Node(data, null, null);
            return;
        }

        root = new Node(data, root, null);
        consolidate();
    }

    private void consolidate() {
        Node curr = root;
        while (null != curr && null != curr.next) {
            Node p = curr;
            Node q = curr.next;
            Node r = null;
            if (p.order == q.order) {
                Node oldNext = q.next;
                if (p.data < q.data) {
                    // P becomes parent of Q
                    q.next = p.child;
                    p.child = q;
                    r = p;
                } else {
                    // Q becomes parent of P
                    p.next = q.child;
                    q.child = p;
                    r = q;
                }
                r.next = oldNext;
                r.order++;
                root = r;
            }
            curr = r != null ? r : curr.next;
        }
    }

    public void offer(int data) {add(data);}
    public int peek() {
        int min = Integer.MAX_VALUE;
        for (Node curr = root; curr != null; curr = curr.next) {
            min = Math.min(min, curr.data);
        }

        return min;
    }

    public void display() {
        display_r(root, 0);
    }

    private void display_r(Node node, int level) {
        for (Node curr = node; curr != null; curr = curr.next) {
            for (int j = 0; j < level; j++) {
                System.out.print("\t");
            }

            System.out.println(curr.data);
            display_r(curr.child, level + 1);
        }
    }

    public static void main(String[] args) {
        BinomialHeap bh = new BinomialHeap();
        Random rand = new Random(3222);

        for (int i = 0; i < 30; i++) {
            int X = Math.abs(rand.nextInt()) % 100;
            System.out.print(X + " ");
            bh.add(X);
        }
        System.out.println("\n\n");

        bh.display();
        System.out.println("\n\nMin = " + bh.peek());
    }
}

