package com.tangm.suanfa;


import java.util.Arrays;
import java.util.logging.Level;

/**
 * 首先定义一个给定序列的子序列，就是将给定序列中零个或多个元素去掉之后得到的结果，
 * 其形式化定义如下：给定一个序列X = <x1,x2 ,..., xm>，
 * 另一个序列Z =<z1,z2 ,..., zk> 满足如下条件时称为X的子序列，即存在一个严格递增的X的下标序列<i1,i2 ,..., ik>，
 * 对于所有j = 1,2,...,k，满足xij = zj，例如，Z=<B,C,D,B>是X=<A,B,C,B,D,A,B>的子序列，对应的下标序列为<2,3,5,7>。
 * 给定两个序列X和Y，如果Z是X的子序列，也是Y的子序列，则称它是X和Y的公共子序列。
 *
 * @author tony
 * @date 2019/4/2
 */
public class Lcs {
    public static void main(String[] args) {
        String a1 = "abcd";
        String a2 = "aebd";
        System.out.println(findLength(a1.toCharArray(), a2.toCharArray()));
    }

    public static int findLength(char[] a1, char[] a2) {
        if (a1 == null || a2 == null || a1.length == 0 || a2.length == 0) {
            return 0;
        }

        int[][] sum = new int[a1.length + 1][a2.length + 1];
        for (int i = 0; i <= a1.length; i++) {
            sum[i][0] = 0;
        }
        for (int i = 0; i <= a2.length; i++) {
            sum[0][i] = 0;
        }
        for (int i = 1; i <= a1.length; i++) {
            for (int j = 1; j <= a2.length; j++) {
                if (a1[i - 1] == a2[j - 1]) {
                    sum[i][j] = sum[i - 1][j - 1] + 1;
                } else {
                    sum[i][j] = Math.max(sum[i - 1][j], sum[i][j - 1]);
                }
            }
        }
        for (int i = 0; i <= a1.length; i++) {
            System.out.println(Arrays.toString(sum[i]));
        }

        return sum[a1.length][a2.length];
    }
}
