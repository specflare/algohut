package com.specflare.algohut.leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * You are given a stream of points on the X-Y plane. Design an algorithm that:
 * Adds new points from the stream into a data structure. Duplicate points are allowed
 * and should be treated as different points.
 * Given a query point, counts the number of ways to choose three points from the data
 * structure such that the three points and the query point form an axis-aligned square with positive area.
 */
// 2013. Detect Squares (Medium)
// https://leetcode.com/problems/detect-squares/
public class DetectSquares {
    private final Map<Integer, List<Integer>> byX = new HashMap<>();
    public DetectSquares() {}
    public void add(int[] point) {
        int xPos = point[0];
        int yPos = point[1];
        if (!byX.containsKey(xPos)) {
            byX.put(xPos, new ArrayList<>());
        }
        byX.get(xPos).add(yPos);
    }

    // still not working with all the tests!!!
    public int count(int[] point) {
        int xPos = point[0];
        int yPos = point[1];
        List<Integer> byXList = byX.getOrDefault(xPos, Collections.emptyList());
        if (byXList.size() == 0) {
            return 0;
        }
        int result = 0;
        for (int y : byXList) {

            if (y == yPos) {
                continue;
            }

            for (Map.Entry<Integer, List<Integer>> kvp : byX.entrySet()) {
                // we now have a line from (xPos, yPos) to (p.x, p.y)
                // we try to find another 2 points with a different x

                if (kvp.getKey() == xPos) {
                    continue;
                }

                if (kvp.getValue().contains(y) && kvp.getValue().contains(yPos)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DetectSquares ds = new DetectSquares();
        ds.add(new int[]{3, 10});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{3, 2});
        System.out.println(ds.count(new int[]{11, 10})); // returns 1
        System.out.println(ds.count(new int[]{14, 8})); // returns 0

        ds.add(new int[]{11, 10});
        ds.add(new int[]{14, 8});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{11, 10});
    }
}
