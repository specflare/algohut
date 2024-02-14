package com.specflare.algohut.algos.graphs;

/**
 * Given a startNode in the Graph, find the shortest paths to all other nodes.
 * It is slower than Dijkstra's algorithm for the same problem, but more versatile, as it is capable
 * of handling graphs in which some of the edge weights are negative numbers.
 *
 * Time complexity: O(V * E)
 *
 * Bellman-Ford is a simple case of DP.
 *
 * Algorithm:
 *  - the distance dist[] to all nodes in the graph is initialized to MAX_INTEGER
 *  - the predecessor pred[] for each node is initialized to -1.
 *  - if (dist[currEdge.src] + currEdge.cost < dist[currEdge.dst]) we update the dist[] to currEdge.dst node.
 *  - repeat last step N-1 times, where N is the number of nodes.
 */

// https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm
// https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
public class BellmanFordShortestPathsDP {
    // Output: shortest distance to all other nodes
    public static void computeBellmanFord(Graph g, int startNode) {
        int[] dist = new int[g.getNumNodes()];
        int[] pred = new int[g.getNumNodes()];

        for (int i = 0; i < g.getNumNodes(); i++) {
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        dist[startNode] = 0;

        // Step 2: relax edges repeatedly N-1 times, where N is the number of nodes.
        for (int node = 0; node < g.getNumNodes() - 1; node++) {
            for (int edge = 0; edge < g.getNumEdges(); edge++) {
                Graph.Edge currEdge = g.edges[edge];
                if (dist[currEdge.src] != Integer.MAX_VALUE && dist[currEdge.src] + currEdge.cost < dist[currEdge.dst]) {
                    dist[currEdge.dst] = dist[currEdge.src] + currEdge.cost;
                    pred[currEdge.dst] = currEdge.src;
                }
            }
        }

        System.out.println("\nBellman-Ford algorithm starting from: " + startNode);
        System.out.print("Distance vector: ");
        for (int node = 0; node < g.getNumNodes(); node++) {
            System.out.print(dist[node] + ", ");
        }
        System.out.println();

        // Step #3: check for negative-weight cycles
        for (int edge = 0; edge < g.getNumEdges(); edge++) {
            Graph.Edge currEdge = g.edges[edge];
            if (dist[currEdge.src] != Integer.MAX_VALUE &&
                    dist[currEdge.src] + currEdge.cost < dist[currEdge.dst]) {
                throw new IllegalStateException("Graph contains a negative weight cycle!");
            }
        }

        System.out.print("Predecessor vector: ");
        for (int node = 0; node < g.getNumNodes(); node++) {
            System.out.print(pred[node] + ", ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(6, 10, false);
        g.initRandom(10);
        g.printGraph();

        computeBellmanFord(g, 3);
    }
}
