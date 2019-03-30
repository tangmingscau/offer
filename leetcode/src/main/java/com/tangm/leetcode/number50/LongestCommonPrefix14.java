package com.tangm.leetcode.number50;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""
 *
 * @author tony
 * @date 2019/3/29
 */
public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //从尾部开始扫描
        String prefix = strs[0];
        for (String s : strs) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //从头开始烧苗
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            prefix=strs[0].substring(0,i);
            boolean isSame = true;
            for (String s : strs) {
                if (s.indexOf(prefix) != 0) {
                    isSame = false;
                    break;
                } else {
                    isSame = true;
                }
            }
            if (!isSame) {
                return prefix == "" ? "" : prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
