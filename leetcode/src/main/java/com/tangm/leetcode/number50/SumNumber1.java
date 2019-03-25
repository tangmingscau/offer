package com.tangm.leetcode.number50;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author tony
 * @date 2019/3/25
 */
public class SumNumber1 {
    public static void main(String[] args) {
        int[] indexs = twoSum(new int[]{2, 5, 7, 9}, 9);
        System.out.println("数组下标:" + Arrays.toString(indexs));
        indexs = twoSumHash2(new int[]{2, 5, 7, 9}, 9);
        System.out.println("数组下标:" + Arrays.toString(indexs));
    }

    /**
     * 两个for循环，暴力解法，时间复杂度大概是O(n^2)
     * <p>
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static int[] twoSumHash(int[] nums, int target) {
        //哈希表发，将nums[]值作为哈希表索引，在利用target-nums[i]=j，hashmap是否包含j,时间复杂度大大优化，O（n）
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int chazhi = target - nums[i];
            if (map.containsKey(chazhi) && map.get(chazhi) != i) {
                return new int[]{i, map.get(chazhi)};
            }
        }
        return new int[]{0, 0};
    }
    public static int[] twoSumHash2(int[] nums,int target){
        //哈希表发，将nums[]值作为哈希表索引，在利用target-nums[i]=j，hashmap是否包含j,时间复杂度大大优化，O（n）
        //比之前优化了空间复杂度
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int chazhi = target - nums[i];
            if (map.containsKey(chazhi) && map.get(chazhi) != i) {
                return new int[]{i, map.get(chazhi)};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
