package com.tangm.leetcode.number50;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * @author tony
 * @date 2019/4/14
 */
public class ThreeSumClosest16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,1,2}, 3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        //指针法
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int cha = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1, result = target - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == result) {
                    return nums[l] + nums[r] + nums[i];
                } else if (nums[l] + nums[r] < result) {
                    if (Math.abs(cha) > Math.abs(nums[l] + nums[r] - result)) {
                        cha = nums[l] + nums[r] - result;
                        min = nums[l] + nums[r] + nums[i];

                    }
                    l++;
                } else {
                    if (Math.abs(cha) > Math.abs(nums[l] + nums[r] - result)) {
                        cha = nums[l] + nums[r] - result;
                        min = nums[l] + nums[r] + nums[i];
                    }
                    r--;
                }
            }
        }
        return min;
    }
}
