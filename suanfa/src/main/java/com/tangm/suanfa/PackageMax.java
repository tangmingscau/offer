package com.tangm.suanfa;

import java.util.Arrays;

/**
 * 背包问题
 * <p>
 * 假设现有容量10kg的背包，另外有3个物品，分别为a1，a2，a3。
 * 物品a1重量为3kg，价值为4；物品a2重量为4kg，价值为5；
 * 物品a3重量为5kg，价值为6。将哪些物品放入背包可使得背包中的总价值最大？
 * <p>
 * 涉及的思想是动态规划
 * 把多阶段过程转化为一系列单阶段问题，利用各阶段之间的关系，逐个求解，创立了解决这类过程优化问题的新方法——动态规划
 * 简单的就是你要将问题找到一个数学表达式，这个数学表达式之间的值有依赖关系
 *
 * @author tony
 * @date 2019/3/31
 */
public class PackageMax {
    public static void main(String[] args) {
        System.out.println(packageMax(10));
    }

    public static int packageMax(int maxWeight) {
        // w[i] :  第i个物体的重量；
        //p[i] : 第i个物体的价值；
        //c[i][m] ： 前i个物体放入容量为m的背包的最大价值；
        //c[i-1][m] ： 前i-1个物体放入容量为m的背包的最大价值；
        //c[i-1][m-w[i]] ： 前i-1个物体放入容量为m-w[i]的背包的最大价值；

        //c[i][m]=MAX(c[i-1][m-w[i]]+p[i],c[i-1][m])
        int[] w = {0, 3, 4, 5};
        int[] p = {0, 4, 5, 6};
        //填充了个0是为了后面的运算符合计算机的index,正常世界物体是第1个开始，而计算机是0
        int n = 3;
        int[][] c = new int[n + 1][maxWeight + 1];
        //填充背包容量为0的值
        for (int i = 0; i < n + 1; i++) {
            c[i][0] = 0;
        }
        //填充没有物体的值
        for (int j = 0; j < maxWeight + 1; j++) {
            c[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {
                //
                if (j < w[i]) {
                    c[i][j] = c[i][j];
                } else {
                    c[i][j] = Math.max(c[i - 1][j - w[i]] + p[i], c[i - 1][j]);
                }

            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            if (c[i][maxWeight] > maxValue) {
                maxValue = c[i][maxWeight];
            }
        }
        return maxValue;
    }
}
