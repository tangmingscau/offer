package com.tangm.leetcode.number50;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author tony
 * @date 2019/3/25
 */
public class ReverseNumber7 {
    public static void main(String[] args) {
        int result = reverse2(123);
        System.out.println("翻转数据:" + result);
    }

    /**
     * @param x
     * @return
     */
    public static int reverse(int x) {
        //MAX_VALUE : 2147483647 MIN_VALUE : -2147483648
        //temp=rev*10+pop
        //采用右移方式
        int pop = 0;
        int rev = 0;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10   //MAX_VALUE : 2147483647
                    || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                //数过大
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10  //MIN_VALUE : -2147483648
                    || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                //数过小
                return 0;
            }
            rev = rev * 10 + pop;
        }

        return rev;
    }

    public static int reverse2(int x) {
        int rev = 0;
        //采用字符串反转方式
        boolean minus = false;
        if (x < 0) {
            x = -x;
            minus = true;
        }
        String s = String.valueOf(x);
        StringBuilder builder = new StringBuilder(s);
        try {
            s = builder.reverse().toString();
            if (minus) {
                s = "-" + s;
            }
            rev = Integer.valueOf(s);
        } catch (Exception e) {

        }
        return rev;
    }
}
