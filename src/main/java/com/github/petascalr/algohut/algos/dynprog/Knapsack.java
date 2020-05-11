package com.github.petascalr.algohut.algos.dynprog;

// Reference: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

public class Knapsack {
    public static class Item {
        public int weight;
        public int value;

        public Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    static int knapsackRec(Item[] items, int n, int capacity) {
        // if we have no more items available or we filled our knapsack
        if (0 == n || 0 == capacity) {
            return 0;
        }

        // we have at least one item available,
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

    // Using memoization
    static int knapsackIterative(Item[] items, int n, int capacity) {
        int K[][] = new int[n + 1][capacity + 1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (items[i - 1].weight <= w)
                    K[i][w] = Math.max(
                            items[i - 1].value + K[i - 1][w - items[i - 1].weight],
                            K[i - 1][w]
                    );
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][capacity];
    }
}
