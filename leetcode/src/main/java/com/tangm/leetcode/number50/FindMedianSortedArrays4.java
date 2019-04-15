package com.tangm.leetcode.number50;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * @author tony
 * @date 2019/4/14
 */
public class FindMedianSortedArrays4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //算法复杂度是O(m*n)
        int[] dp = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            dp[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            dp[nums1.length + i] = nums2[i];
        }
        Arrays.sort(dp);
        if (dp.length % 2 == 0) {
            return (dp[dp.length / 2 - 1] + dp[dp.length / 2]) * 1.0f / 2;
        } else {
            return dp[dp.length / 2];

        }
    }
}
