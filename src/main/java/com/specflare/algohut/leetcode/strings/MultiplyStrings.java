package com.specflare.algohut.leetcode.strings;

// https://leetcode.com/problems/multiply-strings/description/
// 43. Multiply Strings
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String num1_reversed = reverse(num1);
        String num2_reversed = reverse(num2);

        String finalResult = "";
        for (int i = 0; i < num1_reversed.length(); i++) {
            int digit = num1_reversed.charAt(i) - '0';
            String ri = multiplyByDigit(num2_reversed, digit);
            String ri_multiplied = multiplyByPow10(ri, i);
            finalResult = addReversedStrings(finalResult, ri_multiplied);
        }

        return reverse(finalResult);
    }

    public String multiplyByPow10(String s, int n) {
        if (s.length() == 1 && s.charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        sb.append("0".repeat(Math.max(0, n)));
        sb.reverse();
        return sb.toString();
    }

    public String multiplyByDigit(String s, int d) {
        if (0 == d) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < s.length(); i++) {
            int result = (s.charAt(i) - '0') * d + carry;
            carry = result / 10;
            result %= 10;
            sb.append(result);
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.toString();
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private String addReversedStrings(String s1, String s2) {
        if (s1.length() == 0) {
            return s2;
        }

        if (s2.length() == 0) {
            return s1;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(s1.length(), s2.length());
        for (int i = 0; i < maxLength; i++) {
            int s1Digit = (i < s1.length()) ? s1.charAt(i) - '0' : 0;
            int s2Digit = (i < s2.length()) ? s2.charAt(i) - '0' : 0;
            int sum = s1Digit + s2Digit + carry;
            carry = sum / 10;
            sum %= 10;
            sb.append(sum);
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("402", "100"));
        System.out.println(ms.multiply("452", "321"));
        System.out.println(ms.multiply("9", "0"));
        System.out.println(ms.multiply("0", "9"));
        System.out.println(ms.multiply("9", "1"));
        System.out.println(ms.multiply("0", "0"));
        System.out.println(ms.multiply("9", "99912"));
        System.out.println(ms.multiply("98777", "87"));
        System.out.println(ms.multiply("989898989898", "9656789439"));
        System.out.println(ms.multiply("9133", "0"));
        System.out.println(ms.multiply("0", "345345345345"));
    }
}
