package com.specflare.algohut.leetcode.strings;

public class CheckValidString {
//    private boolean helper_r(String s, int i, int sum, boolean[][] dp) {
//        if (i == s.length()) {
//            dp[][]
//            return sum == 0;
//        }
//
//        if (sum < 0 ) {
//            dp[i][sum] = false;
//            return false;
//        }
//
//        char ch = s.charAt(i);
//        if (ch == '(') {
//            return helper_r(s, i + 1, sum + 1);
//        }
//
//        if (ch == ')') {
//            return helper_r(s, i + 1, sum - 1);
//        }
//
//        // ch == '*', we have 3 cases
//        boolean v1 = helper_r(s, i + 1, sum); // skip '*'
//        boolean v2 = helper_r(s, i + 1, sum + 1); // '*' = '('
//        boolean v3 = helper_r(s, i + 1, sum - 1); // '*' = '('
//
//        return v1 || v2 || v3;
//    }
//
//    /*
//    relatia de recurenta:
//        isValid(0, 0) => true;
//        isValid(i=0, s=x)
//     */
//    private boolean helperDP(String s) {
//        // 2D DP; dimensions: i & sum
//        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
//        for (int i = 0; i <= s.length(); i++) {
//            dp[0][i] = true;
//        }
//
//        return dp[][]
//    }
//
//    public boolean checkValidString(String s){
//        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
//        return helper_r(s, 0, 0, dp);
//    }

    public static void main(String[] args) {
//        CheckValidString cvs = new CheckValidString();
//        System.out.println(cvs.checkValidString("(*)"));
//        System.out.println(cvs.checkValidString("()"));
//        System.out.println(cvs.checkValidString("(*))"));
//        System.out.println(cvs.checkValidString("())"));
    }
}
