package com.specflare.algohut.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortingTest {
    @Test
    public void quickSortTest() {
        int[] arr_in = new int[]  {7,3,0,7,3,1,6,4};
        int[] arr_out = new int[] {0,1,3,3,4,6,7,7};
        Sorting.quickSort(arr_in);
        Assertions.assertArrayEquals(arr_in, arr_out);
    }

    @Test
    public void mergeSortTest() {
        int[] arr_in = new int[]  {7,3,0,7,3,1,6,4};
        int[] arr_out = new int[] {0,1,3,3,4,6,7,7};
        Sorting.mergeSort(arr_in);
        Assertions.assertArrayEquals(arr_in, arr_out);
    }

    @Test
    public void insertionSortTest() {
        int[] arr_in = new int[]  {7,3,0,7,3,1,6,4};
        int[] arr_out = new int[] {0,1,3,3,4,6,7,7};
        Sorting.insertionSort(arr_in);
        Assertions.assertArrayEquals(arr_in, arr_out);
    }
}
