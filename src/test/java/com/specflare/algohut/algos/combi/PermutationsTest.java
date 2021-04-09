package com.specflare.algohut.algos.combi;

import org.junit.Test;

public class PermutationsTest {
    @Test
    public void testPermRec() {
        int[] arr = new int[5];
        Permutations.genPermHeapRec(arr, 0, (int[] x) -> {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        });
    }
}
