package com.tangm.leetcode.number50;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 动态规划思想
 *
 * @author tony
 * @date 2019/4/4
 */
public class LongestParlindrome5 {
    public static void main(String[] args) {
        System.out.println(longestPs("aaabaaaa"));
    }

    public static String longestPs(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int begin = 0;
        int maxL = 1;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                begin = i;
                maxL = 2;
                dp[i][i + 1] = 1;
            }
        }
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = i + l - 1;
                if (s.charAt(i ) == s.charAt(j ) && dp[i + 1][j - 1] == 1) {
                    begin = i ;
                    maxL = l;
                    dp[i][j] = 1;
                }
            }
        }

        return s.substring(begin, begin + maxL);
    }
}
