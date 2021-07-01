package com.specflare.algohut.leetcode.arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }


        // now we have maximum n numbers that we need to consider
        // if all n numbers are below N, then we have an increasing seq, so the returning number if n+1
        // if we have at least one missing number between 1 and n, the missing number is easy to find.
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (idx < nums.length && nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        System.out.println(fmp.firstMissingPositive(new int[] {1,2,0}));
    }
}
