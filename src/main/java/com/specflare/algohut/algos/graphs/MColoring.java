package com.specflare.algohut.algos.graphs;

import com.specflare.algohut.Util;

public class MColoring {
    public static boolean generateColoring(Graph g, int numColors) {
        int[] stack = new int[g.getNumNodes()];
        generateAllSolutions_r(g, stack, 0, numColors);
        // generateFirstSolutionOnly_r(g, stack, 0, numColors);
        return true;
    }

    // generates only the first valid solution and then stops.
    private static boolean generateFirstSolutionOnly_r(Graph g, int[] stack, int K, int numColors) {
        if (K == stack.length) {
            Util.printArray(stack, K);
            return true;
        }

        for (int color = 1; color <= numColors; color++) {
            stack[K] = color;
            if (isValidColoringSoFar(g, stack, K) && generateFirstSolutionOnly_r(g, stack, K + 1, numColors)) {
                return true;
            }

            stack[K] = 0;
        }

        return false;
    }

    // generates all possible solutions.
    private static boolean generateAllSolutions_r(Graph g, int[] stack, int K, int numColors) {
        if (K == stack.length) {
            Util.printArray(stack, K);
            return true;
        }

        for (int color = 1; color <= numColors; color++) {
            stack[K] = color;
            if (isValidColoringSoFar(g, stack, K)) {
                generateAllSolutions_r(g, stack, K + 1, numColors);
                stack[K] = 0;
            }
        }

        return true;
    }

    private static boolean isValidColoringSoFar(Graph g, int[] stack, int K) {
        // we need to make sure that all neighbours of K have a different color than K
        for (int j = 0; j < g.adjMatrix[K].length; j++) {
            if (0 == g.adjMatrix[K][j]) {
                continue;
            }

            if (j > K) {
                break;
            }

            if (stack[j] == stack[K]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new int[][] {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        });

        System.out.println(generateColoring(g, 3));
    }
}
