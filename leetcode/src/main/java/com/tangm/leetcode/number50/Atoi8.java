package com.tangm.leetcode.number50;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * @author tony
 * @date 2019/3/29
 */
public class Atoi8 {
    private static String s1 = "42";
    private static String s2 = "   -42";
    private static String s3 = "4193 with words";
    private static String s4 = "words and 987";
    private static String s5 = "-91283472332";
    private static String s6 = "+3.14159";
    private static String s7 = "-91283472332";

    public static void main(String[] args) {
        System.out.println(myAtoi(s7));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        boolean isFirst = true;
        boolean minus = false;
        int number = 0;
        int b = 0;
        int max1 = Integer.MAX_VALUE / 10;
        int min1 = Integer.MIN_VALUE / 10;

        for (char c : chars) {
//            System.out.println((int) c);
            if (isFirst) {
                //检查一下首位是否为有效数字开头,符号和[0,9]
                if (45 == c) {
                    //"-"

                    minus = true;
                } else {
                    if (c >= 48 && c <= 57) {
                        number = c - 48;
                    } else if (c == 43) {
                        //"+"
                    } else {
                        return 0;
                    }
                }
                isFirst = false;
            } else {
                if (c >= 48 && c <= 57) {
                    number = number * 10 + c - 48;
                    if (b == 1) {
                        //溢出，无需继续判断
                        if (minus) {
                            return Integer.MIN_VALUE;
                        } else {
                            return Integer.MAX_VALUE;
                        }
                    } else if (b == 2) {
                        //可能产生溢出，需要二次判断
                        if (minus) {
                            if (c - 48 >= -(Integer.MIN_VALUE % 10)) {
                                return Integer.MIN_VALUE;
                            } else {
                                return -number;
                            }
                        } else {
                            if (c - 48 >= Integer.MAX_VALUE % 10) {
                                return Integer.MAX_VALUE;
                            } else {
                                return number;
                            }

                        }
                    }

                    if (number > max1 || number < min1) {
                        //意味着若是再多一个数字，都会产生溢出
                        b = 1;
                    } else if (number == max1 || number == min1) {
                        //再多一位，有可能溢出，需要二次判断
                        b = 2;
                    }
                } else {
                    return minus ? -number : number;
                }
            }
        }
        return minus ? -number : number;
    }
}
