package com.specflare.algohut;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Skaffolding {

    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(5, m.getOrDefault(5, 0) + 1);
        m.putIfAbsent(3,4);

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            System.out.println(entry);
        }

        for (Integer k : m.keySet()) {
            System.out.println(k);
        }

        for (Integer v : m.keySet()) {
            System.out.println(v);
        }

        System.out.println(m.get(5));

        // ------------------------------------------
        Map<Integer, List<Integer>> ml = new HashMap<>();
    }
}
