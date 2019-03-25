package com.tangm.leetcode.number50;

import java.util.ArrayList;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 如:121
 *
 * @author tony
 * @date 2019/3/25
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        System.out.println("回文数:" + isPalindrome3(10));
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String s1, s2;
        if (s.length() % 2 == 0) {
            s1 = s.substring(0, s.length() / 2);
            s2 = s.substring(s.length() / 2, s.length());
            s2 = new StringBuilder(s2).reverse().toString();
        } else {
            s1 = s.substring(0, s.length() / 2);
            s2 = s.substring(s.length() / 2 + 1, s.length());
            s2 = new StringBuilder(s2).reverse().toString();
        }
        return s1.equals(s2);
    }

    /**
     * 此方案在1到3中耗时最短，复杂度和3虽然一样，但是少了运算，运行相对较快
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            list.add(pop);
            i++;
        }
        for (int j = 0; j < list.size() / 2; j++) {
            if (!list.get(j).equals(list.get(list.size() - j - 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            int pop = x % 10;
            x = x / 10;
            try {
                reverseNum = reverseNum * 10 + pop;//存在溢出的可能性，所以要try{}catch
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return reverseNum == x || reverseNum / 10 == x;
    }

}
