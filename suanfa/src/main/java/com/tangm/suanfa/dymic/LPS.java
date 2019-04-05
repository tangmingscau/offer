package com.tangm.suanfa.dymic;

import java.util.Arrays;

/**
 * 最长回文子串
 * <p>
 * dp[s.size()][s.size()],dp[i][j]表示s[i]到s[j]是否为回文串，dp[i][j]为1表示是，dp[i][j]为0表示不是。
 * 根据s[i]和s[j]是否相等，转移情况如下：
 * <p>
 * s[i] == s[j]，这样的话如果s[i + 1] 到 s[j - 1]是回文串，那么i到j就是回文串，如果s[i + 1]到s[j - 1]不是回文串，那么i到j就不是回文串。dp[i][j] = dp[i + 1][j - 1]
 * s[i] != s[j]，这样的话s[i]到s[j]一定不是回文串。dp[i][j] = 0
 * <p>
 *
 * @author tony
 * @date 2019/4/4
 */
public class LPS {
    public static void main(String[] args) {
        System.out.println(longestPs("aabaa"));
    }

    public static int longestPs(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxL = 1;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                maxL = 2;
            }
        }
        //从长度为3开始计算

        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    maxL = l;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return maxL;
    }
}
