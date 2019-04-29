package com.tangm.leetcode.number50;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * @author tony
 * @date 2019/4/29
 */
public class StringMult43 {
    public static void main(String[] args) {
        System.out.println(multiply("0", "0"));
    }

    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 + n2 == 0) {
            return "0";
        }
        int[] dp = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int a = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                a += dp[i + j + 1];
                dp[i + j + 1] = a % 10;
                dp[i + j] += a / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < dp.length - 1 && dp[i] == 0) {
            i++;
        }
        for (; i < dp.length; i++) {
            stringBuilder.append(dp[i]);
        }
        return stringBuilder.toString().trim();
    }
}
