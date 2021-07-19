package com.specflare.algohut.algos.graphs;

/**
 * Prim's algorithm is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph.
 * It finds a subset of the edges that forms a tree that includes every vertex, where the total weight of
 * all the edges in the tree is minimized
 *
 * A spanning tree is a sub-graph that is connected, and has no cycles.
 *
 * We connect one node at a time. and we always pick the node with the lowest cost to connect to the existing MST.
 */

// https://en.wikipedia.org/wiki/Prim%27s_algorithm
public class PrimMinSpanningTree {
    public static void computePrim(Graph g) {
        int[] parent = new int[g.getNumNodes()];
        int[] cost = new int[g.getNumNodes()];
        boolean[] visited = new boolean[g.getNumNodes()];

        for (int i = 0; i < g.getNumNodes(); i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        // cost[i] is the cost of connecting node i to the tree, not the travel distance between start node and i.
        cost[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < g.getNumNodes() - 1; i++) {
            int minNode = -1;
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < g.getNumNodes(); j++) {
                if (!visited[j] && cost[j] < minCost) {
                    minCost = cost[j];
                    minNode = j;
                }
            }

            if (-1 == minNode) {
                break;
            }

            visited[minNode] = true;

            for (int node = 0; node < g.getNumNodes(); node++) {
                if (!visited[node]
                        && g.adjMatrix[minNode][node] != 0
                        && g.adjMatrix[minNode][node] < cost[node]) {
                    parent[node] = minNode;
                    cost[node] = g.adjMatrix[minNode][node];
                }
            }
        }

        printMST(parent, g);
    }

    private static void printMST(int[] parent, Graph g) {
        System.out.println("Edge \t\tWeight");
        for (int node = 1; node < g.getNumNodes(); node++)
            System.out.println(parent[node] + " - " + node + "\t\t" + g.adjMatrix[node][parent[node]]);
    }
}
