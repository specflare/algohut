package com.specflare.algohut.leetcode.math;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
 * return the maximum number of points that lie on the same straight line.
 */

// https://leetcode.com/problems/max-points-on-a-line/
public class MaxPointsOnALine {
    private static class Line {
        int a1, a2;
        int b1, b2;

        public Line(int a1, int a2, int b1, int b2) {
            this.a1 = a1;
            this.a2 = a2;
            this.b1 = b1;
            this.b2 = b2;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Line)) {
                return false;
            }

            Line rhs = (Line)obj;
            return (a1 == rhs.a1 && a2 == rhs.a2 && b1 == rhs.b1 && b2 == rhs.b2);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + a1;
            result = 31 * result + a2;
            result = 31 * result + b1;
            result = 31 * result + b2;
            return result;
        }
    }

    private Line getLineFrom2Points(int x1, int y1, int x2, int y2) {
        int dx = (x2 - x1);
        int dy = (y2 - y1);
        if (0 == dx) {
            return new Line(Integer.MAX_VALUE, 0, x1, x2); // x1 and x2 are equal
        }

        if (0 == dy) {
            return new Line(0, 0, y1, y2); // y1 and y2 are equal
        }

        int m_gcd = BigInteger.valueOf(dy).gcd(BigInteger.valueOf(dx)).intValue();
        int m1 = dy / m_gcd;
        int m2 = dx / m_gcd;

        // m1 should always be positive
        if (m1 < 0) {
            m1 *= -1;
            m2 *= -1;
        }

        int n1 = x2 * y1 - x1 * y2;
        int n2 = dx;
        int n_gcd = BigInteger.valueOf(n1).gcd(BigInteger.valueOf(n2)).intValue();
        n1 /= n_gcd;
        n2 /= n_gcd;

        if (n1 < 0) {
            n1 *= -1;
            n2 *= -1;
        }

        if (0 == n1) {
            return new Line(m1, m2, 0, 1);
        }

        return new Line(m1, m2, n1, n2);
    }

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length; // 0, 1, or 2
        }
        final Map<Line, Integer> lines = new HashMap<>();
        int maxCountTotal = 1;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = getLineFrom2Points(points[i][0], points[i][1], points[j][0], points[j][1]);
                lines.put(line, lines.getOrDefault(line, 1) + 1);
            }
            int maxCountForThisPoint = 1;
            for (Map.Entry<Line, Integer> kvp : lines.entrySet()) {
                if (kvp.getValue() > maxCountForThisPoint) {
                    maxCountForThisPoint = kvp.getValue();
                }
            }
            lines.clear();
            maxCountTotal = Math.max(maxCountTotal, maxCountForThisPoint);
        }
        return maxCountTotal;
    }

    public static void main(String[] args) {
        MaxPointsOnALine mpol = new MaxPointsOnALine();
        int[][] points1 = {{1,1}, {2,2}, {3,3}};
        System.out.println(mpol.maxPoints(points1));

        int[][] points2 = {{1,1}, {1,2}, {2,2}, {3,3}};
        System.out.println(mpol.maxPoints(points2));

        int[][] points3 = {{0,0}, {0,1}};
        System.out.println(mpol.maxPoints(points3));

        int[][] points4 = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(mpol.maxPoints(points4));

        System.out.println();
    }
}
