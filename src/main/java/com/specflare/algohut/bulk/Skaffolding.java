package com.specflare.algohut.bulk;

import java.util.*;
import java.util.concurrent.Executor;

public class Skaffolding {

    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(5, m.getOrDefault(5, 0) + 1);
        m.putIfAbsent(3,4);

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("Keys: ");
        for (Integer k : m.keySet()) {
            System.out.println(k);
        }

        System.out.println("Values: ");
        for (Integer v : m.values()) {
            System.out.println(v);
        }

        System.out.println(m.get(5));

        usingLists();

        Executor ex;
    }

    private static void usingLists() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(2);
        Collections.sort(list, (a, b) -> b - a);
        System.out.println(list);
    }

    private static void usingStrings() {

    }

    private static void usingPQs() {
//        PriorityQueue<Integer> upperHalf, lowerHalf, freqHeap;
//        upperHalf = new PriorityQueue<>(); // MinHeap
//        lowerHalf = new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap
//        freqHeap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
    }
}
