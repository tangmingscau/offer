package com.tangm.leetcode.number100;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * @author tony
 * @date 2019/4/7
 */
public class Merge88 {
    public static void main(String[] args) {
        int[] num1 = {4, 5, 6, 0, 0, 0};
        int[] num2 = {1, 2, 3};
        int n = 3, m = 3;
        merge2(num1, m, num2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        return;
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        //居然之前nums1之前是有序的，选择插入算法,将num2数组插入num1原先数据中
        for (int i = m; i < m + n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums1[j + 1] < nums1[j]) {
                    int temp = nums1[j + 1];
                    nums1[j + 1] = nums1[j];
                    nums1[j] = temp;
                } else {
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(nums1));
        return;
    }

}
