package com.tangm.leetcode.number50;

/**
 * @author tony
 * @date 2019/4/21
 */
public class SameNumDelete26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        //移动数组，这种方法能返回正确的数据数据，不过返回n效率不高
        int right = nums.length;
        for (int i = 0; i < right - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < right - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                right--;
                i--;
            }
        }
        return right;
    }

    public static int removeDuplicates2(int[] nums) {
        //指针法
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
