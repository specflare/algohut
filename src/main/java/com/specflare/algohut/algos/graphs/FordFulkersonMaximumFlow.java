package com.specflare.algohut.algos.graphs;

import java.util.LinkedList;

// Repeat BFS until there is no more path from start to end.
// For each path found by BFS, generate a new residual graph with the costs diminished by the previous flow.
// BFS is used because the path from start to end does not necessarily need to be the shortest one.
public class FordFulkersonMaximumFlow {
    public int computeMaxFlow(Graph g, int startNode, int endNode) {
        Graph residualGraph = new Graph(g.adjMatrix);

        int[] parent = new int[g.getNumNodes()];
        int maxFlow = 0;

        while(bfs(residualGraph, startNode, endNode, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int node = endNode; node != startNode; node = parent[node]) {
                pathFlow = Math.min(pathFlow, residualGraph.adjMatrix[parent[node]][node]);
            }

            for (int node = endNode; node != startNode; node = parent[node]) {
                int other = parent[node];
                residualGraph.adjMatrix[other][node] -= pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private boolean bfs(Graph g, int startNode, int endNode, int[] parent) {
        boolean[] visited = new boolean[g.getNumNodes()];
        for (int i = 0; i < g.getNumNodes(); ++i) {
            visited[i] = false;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        parent[startNode] = -1;

        while (queue.size() != 0) {
            int currNode = queue.poll();

            for (int otherNode = 0; otherNode < g.getNumNodes(); otherNode++) {
                if (!visited[otherNode] && g.adjMatrix[currNode][otherNode] > 0) {
                    // If we find a connection to the sink node, then there is no point in BFS
                    // anymore We just have to set its parent and can return true.
                    if (otherNode == endNode) {
                        parent[otherNode] = currNode;
                        return true;
                    }

                    queue.add(otherNode);
                    parent[otherNode] = currNode;
                    visited[otherNode] = true;
                }
            }
        }
        // We didn't reach sink in BFS starting from source, so return false
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new int[][] {
                { 0, 16, 13, 0, 0, 0 },
                { 0, 0, 10, 12, 0, 0 },
                { 0, 4, 0, 0, 14, 0 },
                { 0, 0, 9, 0, 0, 20 },
                { 0, 0, 0, 7, 0, 4 },
                { 0, 0, 0, 0, 0, 0 }});

        g.printGraph();

        FordFulkersonMaximumFlow ffmf = new FordFulkersonMaximumFlow();
        System.out.println("MaxFlow is: " + ffmf.computeMaxFlow(g, 0, 5));
    }
}
