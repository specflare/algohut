package com.specflare.algohut.algos.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * For a given source node in the graph, the algorithm finds the shortest path between that node and every other.
 * It can also be used for finding the shortest paths from a single node to a single destination node by
 * stopping the algorithm once the shortest path to the destination node has been determined.
 *
 * Dijkstra works on the Adjacency Matrix.
 * Overall idea: we always try to expand the node with the lowest cost.
 * Once expanded, we exapnd its neighbours in the same manner.
 */

public class DijkstraShortestPaths {
    public static void computeDijkstra(Graph g, int startNode) {
        Set<Integer> nodes = new HashSet<>();
        int[] dist = new int[g.getNumNodes()];
        int[] pred = new int[g.getNumNodes()];

        for (int i = 0; i < g.getNumNodes(); i++) {
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;

            nodes.add(i);
        }

        dist[startNode] = 0;

        while (!nodes.isEmpty()) {
            // we pick the node with the lowest cost starting from startNode
            int minCost = Integer.MAX_VALUE;
            int minNode = -1;
            for (int i : nodes) {
                if (dist[i] < minCost) {
                    minCost = dist[i];
                    minNode = i;
                }
            }

            if (-1 == minNode) {
                break;
            }

            nodes.remove(minNode);

            // for each neighbor of minNode
            for (int j = 0; j < g.getNumNodes(); j++) {
                if (j == minNode || g.adjMatrix[minNode][j] == 0) {
                    continue;
                }

                int newDist = dist[minNode] + g.adjMatrix[minNode][j];
                if (newDist < dist[j]) {
                    dist[j] = newDist;
                    pred[j] = minNode;
                }
            }
        }

        System.out.print("\nDijkstra's algorithm starting from: " + startNode);
        System.out.print("\nDistance vector: ");
        for (int node = 0; node < g.getNumNodes(); node++) {
            System.out.print(dist[node] + ", ");
        }

        System.out.print("\nPredecessor vector: ");
        for (int node = 0; node < g.getNumNodes(); node++) {
            System.out.print(pred[node] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(6, 10, false);
        g.initRandom(10);
        g.printGraph();

        computeDijkstra(g, 3);
    }
}
