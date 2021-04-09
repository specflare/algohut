package com.specflare.algohut.algos.dynprog;

// Reference: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

// Given a Knapsack that can carry weight=W, and a list of items with value and weights,
// what is the maximum value that can fit in the Knapsack.
public class Knapsack {
    public static class Item {
        public int weight;
        public int value;

        public Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    // returns the maximum value of the Knapsack.
    static int knapsackRec(Item[] items, int n, int capacity) {
        // if we have no more items available or we filled our knapsack
        if (0 == n || 0 == capacity) {
            return 0;
        }

        // we have at least one item available,
        // If weight of the nth item is more than Knapsack capacity W,
        // then this item cannot be included in the optimal solution.
        Item it = items[n - 1];
        if (it.weight > capacity) {
            return knapsackRec(items, n - 1, capacity);
        }

        // we need to decide if we put it in the knapsack or not, so we test both ways at every level.
        return Math.max(
                it.value + knapsackRec(items, n - 1, capacity - it.weight),
                knapsackRec(items, n - 1, capacity)
        );
    }

    // Iterative approach: bottom-up.
    static int knapsackIterative(Item[] items, int n, int capacity) {
        int K[][] = new int[n + 1][capacity + 1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                }
                else if (items[i - 1].weight <= w) {
                    // weight of the current item is less than the current w.
                    // we have 2 options: put it in Knapsack or not put it.
                    K[i][w] = Math.max(
                            // we put it: so we take the old value and we add the current value.
                            items[i - 1].value + K[i - 1][w - items[i - 1].weight],
                            K[i - 1][w]); // go on with the value accumulated for the previous item and weight.
                }
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        System.out.println("Items x Capacities: ");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                System.out.print(K[i][w] + " ");
            }

            System.out.println();
        }

        return K[n][capacity];
    }
}
