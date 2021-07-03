package com.specflare.algohut.leetcode.graphs;

import java.util.HashSet;
import java.util.Set;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            int start = i;
            for (int j = 0; j < graph[i].length; j++) {
                int end = graph[i][j];

                if (left.contains(start)) {
                    if (right.contains(start)) {
                        return false;
                    }

                    if (right.contains(end)) {
                        // do nothing
                    } else {
                        right.add(end);
                    }
                } else {

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite bg = new IsGraphBipartite();
        System.out.println(bg.isBipartite(new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}}));
    }
}
