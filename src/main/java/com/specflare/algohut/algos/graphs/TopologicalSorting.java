package com.specflare.algohut.algos.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for
 * every directed edge uv, vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 *
 * Algorithm:
 *  1. We compute the in-degree of all nodes and add them to a queue if the in-degree is zero.
 *  2. We take the first elem from the queue, and check its neighbours and decrease their in-degree by 1.
 *  3. If any of its neighbours reach an in-degree of 0, we add it to the queue as well.
 *  4. Repeat from step 1 until queue is empty.
 */

// https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
public class TopologicalSorting {
    // it works in O(V + E), if the graph is represented as edges list

    public static List<Integer> topologicalSort(Graph g) {
        int N = g.getNumNodes();
        int[] indegree = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (g.adjMatrix[i][j] != 0) {
                    indegree[j]++;
                }
            }
        }

        // create a queue with all nodes with in-degree == 0.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);

            // get all neighbours of u, and decrease their in-degree by 1.
            for (int i = 0; i < N; i++) {
                if (g.adjMatrix[u][i] != 0) {
                    if (--indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        if (result.size() != N) {
            System.out.println("Graph contains cycles!!!");
            return new LinkedList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new int[][] {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,1,0,0},
                {0,1,0,0,0,0},
                {1,1,0,0,0,0},
                {1,0,1,0,0,0}
        });

        System.out.println(topologicalSort(g));
    }
}
