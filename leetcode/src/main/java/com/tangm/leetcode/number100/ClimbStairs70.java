package com.tangm.leetcode.number100;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author tony
 * @date 2019/4/7
 */
public class ClimbStairs70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 斐波那列
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int l1 = 1, l2 = 2;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        for (int i = 3; i <= n; i++) {
            int l = l1 + l2;
            l1 = l2;
            l2 = l;
        }
        return l2;
    }
}
