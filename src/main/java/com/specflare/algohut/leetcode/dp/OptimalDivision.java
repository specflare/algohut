package com.specflare.algohut.leetcode.dp;

/**
 * You are given an integer array nums. The adjacent integers in nums will perform the float division.
 * For example, for nums = [2,3,4], we will evaluate the expression "2/3/4".
 * However, you can add any number of parenthesis at any position to change the priority of operations.
 * You want to add these parentheses such the value of the expression after the evaluation is maximum.
 * Return the corresponding expression that has the maximum value in string format.
 *
 * Note: your expression should not contain redundant parenthesis.
 */
// https://leetcode.com/problems/optimal-division/
// 553. Optimal Division (Medium)
public class OptimalDivision {
    private static class Result {
        float minVal, maxVal;
        String minExpr, maxExpr;

        public Result(float minv, float maxv, String minE, String maxE) {
            this.minVal = minv;
            this.maxVal = maxv;
            this.minExpr = minE;
            this.maxExpr = maxE;
        }
    }

    public String optimalDivision(int[] nums) {
        Result[][] memo = new Result[nums.length][nums.length];
        Result r = compute(nums, 0, nums.length - 1, memo);
        return r.maxExpr;
    }

    private Result compute(int[] nums, int left, int right, Result[][] memo) {
        if (null != memo[left][right]) {
            return memo[left][right];
        }

        if (left == right) {
            memo[left][right] = new Result(nums[left], nums[left], "" + nums[left], "" + nums[left]);
            return memo[left][right];
        }

        float minValue = Float.MAX_VALUE, maxValue = Float.MIN_VALUE;
        String minExpr = "", maxExpr = "";

        for (int i = left; i < right; i++) {
            Result leftRes = compute(nums, left, i, memo);
            Result rightRes = compute(nums, i + 1, right, memo);
            int sizeOfRightExpr = right - i - 1;
            float newMinValue = leftRes.minVal / rightRes.maxVal;

            if (newMinValue < minValue) {
                minValue = newMinValue;
                minExpr = (sizeOfRightExpr > 0) ? leftRes.minExpr + "/(" + rightRes.maxExpr + ")" : leftRes.minExpr + "/" + rightRes.maxExpr;
            }

            float newMaxValue = leftRes.maxVal / rightRes.minVal;
            if (newMaxValue > maxValue) {
                maxValue = newMaxValue;
                maxExpr = (sizeOfRightExpr > 0) ? leftRes.maxExpr + "/(" + rightRes.minExpr + ")" : leftRes.maxExpr + "/" + rightRes.minExpr;
            }
        }

        memo[left][right] = new Result(minValue, maxValue, minExpr, maxExpr);
        return memo[left][right];
    }

    public static void main(String[] args) {
        OptimalDivision od = new OptimalDivision();
        System.out.println(od.optimalDivision(new int[] {3,5}));
        System.out.println(od.optimalDivision(new int[] {1000,100, 10}));

        System.out.println(od.optimalDivision(new int[] {2,3,4}));
        System.out.println(od.optimalDivision(new int[] {2}));
        System.out.println(od.optimalDivision(new int[] {100,10,1}));

        System.out.println("-----------");
        System.out.println(od.optimalDivision(new int[] {10, 100, 10, 100, 100, 10000, 5, 2}));
        System.out.println(od.optimalDivision(new int[] {1000,100, 10, 2}));
    }
}
