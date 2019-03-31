package com.tangm.suanfa;

/**
 * 假设1元、2元、5元、10元、20元、50元、100元的纸币，张数不限制，现在要用来支付K元，至少要多少张纸币？
 * <p>
 * 贪心算法
 * <p>
 * 贪心策略适用的前提是：局部最优策略能导致产生全局最优解。也就是当算法终止的时候，局部最优等于全局最优。
 *
 * @author tony
 * @date 2019/3/31
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        System.out.println(findChange(203));
    }

    public static int findChange(int k) {
        //每次支付的时候尝试支付最大面额的金钱，这样子，就能得到最优解
        int[] moneys = {1, 2, 5, 10, 20, 50, 100};
        int alreadyPay = 0;
        int num = 0;
        while (alreadyPay < k) {
            for (int i = moneys.length - 1; i >= 0; i--) {
                if (alreadyPay + moneys[i] > k) {

                } else {
                    alreadyPay += moneys[i];
                    num++;
                    break;
                }
            }
        }
        return num;
    }
}
