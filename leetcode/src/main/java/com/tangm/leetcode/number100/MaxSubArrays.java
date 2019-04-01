package com.tangm.leetcode.number100;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author tony
 * @date 2019/4/1
 */
public class MaxSubArrays {
    static int[] a1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    static int[] a2={-1};
    public static void main(String[] args) {
        System.out.println(maxSubArray(a2));
    }

    public static int maxSubArray(int[] nums) {
        //动态规划思想
        int[] maxSums = new int[nums.length];

        int start = 0, end = 1;
        maxSums[start] = nums[start];
        for (end = 1; end < nums.length; end++) {
            maxSums[end] = Math.max(maxSums[end - 1] + nums[end], nums[end]);
        }
        int max = nums[start];
        for (int i = 0; i < maxSums.length; i++) {
            if (max < maxSums[i]) {
                max = maxSums[i];
            }
        }
        return max;
    }
}
