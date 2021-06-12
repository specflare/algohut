package com.specflare.algohut.heaps;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MinHeap { // root is minimum
    private int[] arr;
    private int n = 0;
    private int capacity = 0;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public boolean isEmpty() {
        return 0 == n;
    }

    public void add(int key) {
        if (n < capacity - 1) {
            arr[n++] = key;
        } else {
            // resize
            int newCapacity = capacity * 2;
            arr = Arrays.copyOf(arr, newCapacity);
        }

        heapify_up(n - 1);
    }

    private void heapify_down(int pos) {
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        int largest = pos;

        if (left < capacity && arr[left] > arr[pos]) {
            largest = left;
        }

        if (right < capacity && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != pos) {
            // swap arr[pos] with arr[largest]
            arr[pos] ^= arr[largest];
            arr[largest] ^= arr[pos];
            arr[pos] ^= arr[largest];

            // now we move down the rabbit hole
            heapify_down(largest);
        }
    }

    private void heapify_up(int pos) {
        int parent = (pos - 1) / 2;
        if (pos > 0 && arr[parent] > arr[pos]) {
            arr[pos] ^= arr[parent];
            arr[parent] ^= arr[pos];
            arr[pos] ^= arr[parent];

            // we move up the chain
            heapify_up(parent);
        }
    }

    public int pop() { // removes minimum element (root)
        if (n == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int result = arr[0];
        arr[0] = arr[n - 1]; // replace root with the last elem added, then heapify it down.
        heapify_down(0);
        return result;
    }

    // returns min element - root, but does not remove it
    public int peek() {
        if (n == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return arr[0];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap(1024);

        for (int i = 0; i < 20; i++) {
            int X = Math.abs(ThreadLocalRandom.current().nextInt()) % 128;
            System.out.print(X + " ");
            mh.add(X);
        }
        System.out.println();
        System.out.println(mh);
    }
}
