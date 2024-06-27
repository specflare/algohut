package com.specflare.algohut.leetcode.arrays;

import java.util.*;

/**
 * A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above.
 * Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i] = [3,8] means the seat
 * located in row 3 and labelled with 8 is already reserved.
 * Return the maximum number of four-person groups you can assign on the cinema seats. A four-person group occupies
 * four adjacent seats in one single row. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent,
 * but there is an exceptional case on which an aisle split a four-person group, in that case, the aisle split a
 * four-person group in the middle, which means to have two people on each side.
 */
// https://leetcode.com/problems/cinema-seat-allocation/
// 1386. Cinema Seat Allocation (Medium)
public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        if (null == reservedSeats || reservedSeats.length < 1 || reservedSeats[0].length < 2) {
            return 0;
        }

        Arrays.sort(reservedSeats, Comparator.comparingInt(arr -> arr[0]));

        int prevRow = 0;
        int rowData = 0;
        int count = 0;
        int numDistinctRows = 0;
        for (int i = 0; i < reservedSeats.length; i++) {
            int[] entry = reservedSeats[i];
            int row = entry[0];
            if (row != prevRow) {
                numDistinctRows++;
                if (prevRow != 0) {
                    int thisCount = getNumFamilies(rowData);
                    count += thisCount;
                }

                prevRow = row;
                rowData = 0;
            }

            int col = entry[1];
            rowData |= (1 << (col - 1));
        }

        count += (n - numDistinctRows) * 2;
        count += getNumFamilies(rowData);

        return count;
    }

    // rowData is a bitmask (10 bits) containing a set bit for each occupied seat.
    private int getNumFamilies(int rowData) {
        // there are 3 possible arrangements.
        int pos_right  = 0b000_0011_110;
        int pos_middle = 0b000_1111_000;
        int pos_left   = 0b011_1100_000;

        // first try to put 2 families on the row
        if ((0 == (rowData & pos_right)) && (0 == (rowData & pos_left))) {
            return 2;
        }

        // then try to put 1 family on the row, in the middle
        if (0 == (rowData & pos_middle) || (0 == (rowData & pos_right)) || (0 == (rowData & pos_left))) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        CinemaSeatAllocation csa = new CinemaSeatAllocation();
//        System.out.println(csa.maxNumberOfFamilies(3, new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));
//        System.out.println(csa.maxNumberOfFamilies(2, new int[][]{{2,1}, {1,8}, {2,6}}));
//        System.out.println(csa.maxNumberOfFamilies(4, new int[][]{{4,3},{1,4},{4,6},{1,7}}));
//
//        System.out.println(csa.maxNumberOfFamilies(10, new int[][]{
//                {1, 4}, // row 1 only 1 family.
//                {5, 2},
//                {5, 6}, // row 5 is out.
//        }));

//        System.out.println(csa.maxNumberOfFamilies(4, new int[][]{
//                {1, 2},
//                {1, 6},
//                {2, 2},
//                {2, 6},
//        }));
//        System.out.println(csa.maxNumberOfFamilies(1, new int[][]{
//                {1, 2},
//                // {1, 6}
//        }));

        System.out.println(csa.maxNumberOfFamilies(2, new int[][]{
                {1,5},
                {2,8},
                {2,10},
                {2,2},
                {1,6},
                {1,10},
                {1,1},
                {2,5},
                {1,2}
        }));
    }
}
