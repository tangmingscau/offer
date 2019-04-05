package com.tangm.leetcode.number100;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * @author tony
 * @date 2019/4/4
 */
public class MinEditor72 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            if (word2 != null) {
                return word2.length();
            } else {
                return 0;
            }
        }
        if (word2 == null || word2.length() == 0) {
            if (word1 != null) {
                return word1.length();
            } else {
                return 0;
            }
        }
        //dp[i][j] 代表的是a[i]变成b[j]所需要的编辑步骤
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //状态转移方程还是从末尾看起，根据末尾a[i]和b[j]是不是相等，转移情况分为：
                //
                //如果a[i] == b[j]（注意我们代码中的dp定义的下标都是比字符串的下标前进一个，上面那个题目也是这样的，这里只是为了说明方便一些，让字符串的下标从1开始了），那么这一位就是不需要编辑的。dp[i][j] = dp[i - 1][j - 1]；
                //如果a[i] != b[j]，这个情况就比较复杂了，这涉及到我们怎么去操作。
                //a.修改操作，如果把a[i]改成b[j]，或者b[j]改成a[i]，那么就操作数加一，两个同时往前缩，我们去关注前面的子串，这样dp[i][j] = dp[i - 1][j - 1] + 1
                //b.删除操作，把a[i]直接删除掉，去看a的前面的子串有没有可能跟b相等，那么操作数加一，这时候关注的a的指针要前移一位，而对b则还是关注原来的位置，这样dp[i][j] = dp[i - 1][j] + 1，而同理可以去删除b[i]，对应的状态转移方程为dp[i][j] = dp[i][j - 1] + 1
                //c.添加操作，在a[i]后面去追加个b[i]，这样相当于把a的关注的指针后移到了i+1处，那么接下来要往前缩了，a往前缩就是i，b往前缩就是i-1，所以dp[i][j] = dp[i][j - 1]+1，而同理，去给b加a[i]的话，结果就是dp[i][j] = dp[i - 1][j]+1
                //然后上面的abc中总共下来其实就是3个状态转移方程，取其中的最小值即可。

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
