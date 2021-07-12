package com.specflare.algohut.algos.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnapsackTest {
    static final int KNAPSACK_CAPACITY = 20;
    static final int EXPECTED_CARRIED_VAL = 17;

    static final Knapsack.Item[] items = new Knapsack.Item[] {
            new Knapsack.Item(3, 2),
            new Knapsack.Item(7, 4),
            new Knapsack.Item(3, 2),
            new Knapsack.Item(4, 1),
            new Knapsack.Item(8, 6),
            new Knapsack.Item(5, 7),
    };

    @Test
    public void knapsackRecTest() {
        Assertions.assertEquals(EXPECTED_CARRIED_VAL, Knapsack.knapsackRec(items, items.length, KNAPSACK_CAPACITY));
    }

    @Test
    public void knapsackIterativeTest() {
        Assertions.assertEquals(EXPECTED_CARRIED_VAL, Knapsack.knapsackIterative(items, items.length, KNAPSACK_CAPACITY));
    }
}
