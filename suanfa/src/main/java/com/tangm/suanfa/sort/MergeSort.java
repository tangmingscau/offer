package com.tangm.suanfa.sort;

import java.util.Arrays;

/**
 * 归并排序 https://www.cnblogs.com/chengxiao/p/6194356.html
 * <p>
 * <p>
 * 归并排序采用分治的思想：
 * <p>
 * Divide：将n个元素平均划分为各含n/2个元素的子序列；
 * Conquer：递归的解决俩个规模为n/2的子问题；
 * Combine：合并俩个已排序的子序列。
 * 性能：时间复杂度总是为O(NlogN)，空间复杂度也总为为O(N)，算法与初始序列无关，排序是稳定的。
 *
 * @author tony
 * @date 2019/3/5
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = DataProvider.generateRandomArray(1000, 0, 1000);
        System.out.println("归并排序\n");
        long start = System.currentTimeMillis();
        mergeSort(array.clone());
        System.out.println("归并排序耗时" + (System.currentTimeMillis() - start) + "\n");

    }

    private static void mergeSort(int[] toSorts) {
        mergeSort(toSorts, 0, toSorts.length - 1, new int[toSorts.length]);
        System.out.println(Arrays.toString(toSorts));
    }

    private static void mergeSort(int[] toSorts, int left, int right, int[] temps) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(toSorts, left, mid, temps);//左边归并排序，使左边有序
            mergeSort(toSorts, mid + 1, right, temps);//右边归并排序，使右边有序
            merge(toSorts, left, mid, right, temps); //将左右有序的队列合并
        }
    }

    private static void merge(int[] toSorts, int left, int mid, int right, int[] temps) {
        int i = left;//左序列索引
        int j = mid + 1;//右序列索引
        int tempIndex = 0; //临时索引
        while (i <= mid && j <= right) {
            //从小到大将有序序列放到临时数组中
            if (toSorts[i] > toSorts[j]) {
                temps[tempIndex++] = toSorts[j++];
            } else {
                temps[tempIndex++] = toSorts[i++];
            }
        }
        while (i <= mid) { //将剩余的左序列数据填充到临时数组中
            temps[tempIndex++] = toSorts[i++];
        }
        while (j <= right) {
            //将剩余的右序列数据填充到临时数组中
            temps[tempIndex++] = toSorts[j++];
        }
        tempIndex = 0;
        while (left <= right) {
            //将数据拷贝到原始数据中
            toSorts[left++] = temps[tempIndex++];
        }
    }

}
