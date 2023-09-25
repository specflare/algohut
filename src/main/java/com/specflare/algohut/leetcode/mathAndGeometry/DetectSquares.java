package com.specflare.algohut.leetcode.mathAndGeometry;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2013. Detect Squares (Medium)
// https://leetcode.com/problems/detect-squares/
public class DetectSquares {
    private final Map<Integer, List<Integer>> byX = new HashMap<>();
    private final Map<Integer, List<Integer>> byY = new HashMap<>();
    public DetectSquares() {}

    public void add(int[] point) {
        if (!byX.containsKey(point[0])) {
            byX.put(point[0], List.of(point[1]));
        } else {
            byX.get(point[0]).add(point[1]);
        }

        if (!byY.containsKey(point[1])) {
            byY.put(point[1], List.of(point[0]));
        } else {
            byY.get(point[1]).add(point[0]);
        }
    }

    public int count(int[] point) {
        int byXCount = byX.getOrDefault(point[0], Collections.emptyList()).size();
        int byYCount = byY.getOrDefault(point[1], Collections.emptyList()).size();

        if (byXCount == 0 || byYCount == 0) {
            return 0;
        }

        if (byXCount < byYCount) {
            List<Integer> byXList = byX.get(point[0]);
            long count1 = byXList.stream().filter(byY::containsKey).count();
        }

        return 1;
    }
}
