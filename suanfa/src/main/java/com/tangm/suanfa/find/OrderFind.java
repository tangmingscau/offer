package com.tangm.suanfa.find;


import com.tangm.suanfa.sort.DataProvider;
import com.tangm.suanfa.sort.InsertSort;

/**
 * @author tony
 * @date 2019/3/6
 */
public class OrderFind {
    public static void main(String[] args) {
        int[] array = DataProvider.generateRandomArray(10000, 0, 10000);
        System.out.println("插入排序\n");
        long start = System.currentTimeMillis();
        InsertSort.insertSort2(array);
        System.out.println("插入排序耗时" + (System.currentTimeMillis() - start) + "\n");
        System.out.println("顺序查找=" + orderFind(array, 6789));
        System.out.println("二分查找=" + binarySearch(array, 6789));
        return;
    }

    /**
     * 顺序查找，时间复杂度是O(n),对列表没有排序要求
     */
    public static int orderFind(int[] toFinds, int target) {
        for (int i = 0; i < toFinds.length; i++) {
            if (toFinds[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找，时间复杂度是O(logn)
     *
     * @param toFinds 已经排好序的列表
     * @param target
     * @return
     */
    public static int binarySearch(int[] toFinds, int target) {
        int start = 0;
        int end = toFinds.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (toFinds[mid] == target) {
                return mid;
            } else if (target > toFinds[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
