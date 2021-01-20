package com.github.petascalr.algohut.algos;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortingTest {
    @Test
    public void quickSortTest() {
        int[] arr_in = new int[]  {7,3,0,7,3,1,6,4};
        int[] arr_out = new int[] {0,1,3,3,4,6,7,7};
        Sorting.quickSort(arr_in);
        Assert.assertArrayEquals(arr_in, arr_out);
    }

    @Test
    public void mergeSortTest() {
        int[] arr_in = new int[]  {7,3,0,7,3,1,6,4};
        int[] arr_out = new int[] {0,1,3,3,4,6,7,7};
        Sorting.mergeSort(arr_in);
        Assert.assertArrayEquals(arr_in, arr_out);
    }
}
