package com.specflare.algohut.algos.graphs;

import java.util.*;

public class Graph {
    static class Edge {
        int src, dst, cost;
        public Edge(int s, int d, int c) {
            src = s;
            dst = d;
            cost = c;
        }
    }

    final int[][] adjMatrix;
    Edge[] edges;
    boolean isDirected;

    public int getNumEdges() {return edges.length;}
    public int getNumNodes() {return adjMatrix.length;}
    public boolean getIsDirected() {return isDirected;}

    public Graph(int numNodes, int numEdges, boolean isDirected) {
        adjMatrix = new int[numNodes][numNodes];
        edges = new Edge[numEdges];
        this.isDirected = isDirected;
    }

    public Graph(int[][] adjMatr) {
        this.adjMatrix = new int[adjMatr.length][];
        this.isDirected = false;

        int numEdges = 0;
        for (int i = 0; i < adjMatr.length; i++) {
            this.adjMatrix[i] = new int[adjMatr[i].length];
            // System.arraycopy(adjMatr[i], 0, this.adjMatrix[i], 0, adjMatr[i].length);
            for (int j = 0; j < adjMatr[i].length; j++) {
                this.adjMatrix[i][j] = adjMatr[i][j];

                if (adjMatr[i][j] != 0) {
                    numEdges++;
                }

                if (adjMatr[i][j] != adjMatr[j][i]) {
                    this.isDirected = true;
                }
            }
        }

        edges = new Edge[numEdges];
        int edgeIndex = 0;
        for (int i = 0; i < adjMatr.length; i++) {
            for (int j = 0; j < adjMatr[i].length; j++) {
                if (adjMatr[i][j] != 0) {
                    edges[edgeIndex++] = new Edge(i, j, adjMatr[i][j]);
                }
            }
        }
    }

    public void initRandom(int maxCost) {
        int numEdgesAdjusted = isDirected ? edges.length : edges.length / 2;

        Random rand = new Random(19870503);
        for (int i = 0; i < numEdgesAdjusted; i++) {
            int fromNode, toNode;
            do {
                fromNode = Math.abs(rand.nextInt()) % adjMatrix.length;
                toNode = Math.abs(rand.nextInt()) % adjMatrix.length;
            } while (fromNode == toNode || adjMatrix[fromNode][toNode] != 0);

            int cost = 1 + (Math.abs(rand.nextInt()) % (maxCost - 1));
            adjMatrix[fromNode][toNode] = cost;
            edges[i] = new Edge(fromNode, toNode, cost);

            if (!isDirected) {
                adjMatrix[toNode][fromNode] = cost;
                edges[numEdgesAdjusted + i] = new Edge(toNode, fromNode, cost);
            }
        }

        Arrays.sort(edges, Comparator.comparingInt(e -> e.src));
    }

    public void printGraph() {
        System.out.println(String.format("numNodes = %d, numEdges = %d", adjMatrix.length, edges.length));
        System.out.println("Adjacency matrix: " + adjMatrix.length + " x " + adjMatrix.length);
        System.out.println("{");
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < adjMatrix[i].length - 1; j++) {
                System.out.print(adjMatrix[i][j] + ",\t");
            }
            System.out.println(adjMatrix[i][adjMatrix.length - 1] + "}, ");
        }
        System.out.print("}");

        System.out.println("\n\nNeighbours list: ");
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print("Neighbours of " + i + ": ");
            for (int j = 0; j < adjMatrix.length; j++) {
                if (i == j || adjMatrix[i][j] == 0) {
                    continue;
                }

                System.out.print(String.format("%d ($: %d), ", j, adjMatrix[i][j]));
            }
            System.out.println();
        }

        System.out.println("\nEdges list: numEdges: " + edges.length);
        for (int i = 0; i < edges.length; i++) {
            System.out.println(String.format("SRC: %d, DST: %d, COST: %d", edges[i].src, edges[i].dst, edges[i].cost));
        }
        System.out.println();
    }

    public void depthFirstSearch(int startNode) {
        System.out.print("\nDFS traversal: ");
        boolean[] visited = new boolean[adjMatrix.length];
        dfs_recursive(startNode, visited);
        System.out.println();
    }

    public void dfs_recursive(int currNode, boolean[] visited) {
        currNode %= adjMatrix.length;
        visited[currNode] = true;
        System.out.print(currNode + ", ");

        for (int j = 0; j < adjMatrix.length; j++) {
            if (adjMatrix[currNode][j] != 0 && !visited[j]) {
                dfs_recursive(j, visited);
            }
        }
    }

    public void breadthFirstSearch(int startNode) {
        System.out.print("\nBFS traversal: ");
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int currNode = q.peek();
            System.out.print(currNode + ", ");

            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[currNode][j] > 0 && !visited[j] && j != currNode) {
                    q.add(j);
                    visited[j] = true;
                }
            }

            q.poll();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(6, 12, false);
        g.initRandom(10);
        g.printGraph();
        g.depthFirstSearch(3);
        g.breadthFirstSearch(3);

        BellmanFordShortestPathsDP.computeBellmanFord(g, 3);
        DijkstraShortestPaths.computeDijkstra(g, 3);
        PrimMinSpanningTree.computePrim(g);
    }
}
