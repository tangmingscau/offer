package com.tangm.suanfa.find;

/**
 * 斐波那契算法
 * f(n)=f(n-1)+f(n-2)
 *
 * @author tony
 * @date 2019/3/6
 */
public class FeiBoSum {
    public static void main(String[] args) {
        int n = 30;
        long start = System.currentTimeMillis();
        int result = feiboDiGui(n);
        System.out.println("斐波那契算法递归耗时:" + (System.currentTimeMillis() - start) + " 值=" + result);
        start = System.currentTimeMillis();
        result = feiboDiGui2(n);
        System.out.println("斐波那契算法循环耗时:" + (System.currentTimeMillis() - start) + " 值=" + result);
    }

    public static int feiboDiGui(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return feiboDiGui(n - 1) + feiboDiGui(n - 2);
    }

    public static int feiboDiGui2(int n) {
        int f1 = 1, f2 = 1, t = 0;
        for (int i = 2; i < n; i++) {
            t = f1 + f2;
            f1 = f2;
            f2 = t;
        }
        return t;
    }

}
