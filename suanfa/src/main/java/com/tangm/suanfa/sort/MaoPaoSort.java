package com.tangm.suanfa.sort;


import java.util.Arrays;

/**
 * 冒泡排序，从左到右，从小到大排序
 * 算法时间复杂度O(n^2)
 * @author tony
 * @date 2019/3/2
 */
public class MaoPaoSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 9, 8, 100, 5, 200, 19, 2};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
        int[] array3 = {1, 2, 5, 7, 4, 3, 6, 8, 9, 10};
        System.out.print("经典冒泡\n");
        maopao(array3.clone());
        System.out.print("优化冒泡1\n");
        maopao1(array3.clone());
        System.out.print("优化冒泡2\n");
        maopao2(array3.clone());
    }

    /**
     * 最经典的冒泡排序的写法
     * 代码执行45次
     *
     * @param toSorts
     */
    public static void maopao(int[] toSorts) {
        int count = 0;
        for (int i = 0; i < toSorts.length - 1; i++) {
            for (int j = 0; j < toSorts.length - 1 - i; j++) {
                if (toSorts[j] > toSorts[j + 1]) {
                    //发现有更大的数据，挪到排序开始尾部
                    int temp = toSorts[j + 1];
                    toSorts[j + 1] = toSorts[j];
                    toSorts[j] = temp;
                    System.out.print("toSorting=" + Arrays.toString(toSorts) + "\n");
                }
                count++;
            }
        }
        System.out.print("count=" + count + "\n");
        System.out.print("toSorts=" + Arrays.toString(toSorts) + "\n");
    }

    /**
     * 优化点1:
     * 设置标志位，若是没发生过数据交换，则说明列表已经有序，直接省略后续排序
     * 代码执行35次
     *
     * @param toSorts
     */
    public static void maopao1(int[] toSorts) {
        int count = 0;
        for (int i = 0; i < toSorts.length - 1; i++) {
            boolean hasSwitch = false;//标志位，是否发生过交换数据
            for (int j = 0; j < toSorts.length - 1 - i; j++) {
                if (toSorts[j] > toSorts[j + 1]) {
                    int temp = toSorts[j + 1];
                    toSorts[j + 1] = toSorts[j];
                    toSorts[j] = temp;
                    System.out.print("toSorting=" + Arrays.toString(toSorts) + "\n");
                    hasSwitch = true;
                }
                count++;
            }
            if (!hasSwitch) {
                //若是没有发生过数据交换，则说明队列已经有序
                break;
            }
        }
        System.out.print("count=" + count + "\n");
        System.out.print("toSorts=" + Arrays.toString(toSorts) + "\n");
    }

    /**
     * 优化点2:
     * 设置标志位，若是没发生过数据交换，则说明列表已经有序，直接省略后续排序
     * 并且记录最后一次交换pos的位置，因为[pos,length]是有序的
     *
     * @param toSorts
     */
    public static void maopao2(int[] toSorts) {
        int count = 0;
        int lastPos = toSorts.length - 1;
        for (int i = 0; i < toSorts.length - 1; i++) {
            boolean hasSwitch = false;//标志位，是否发生过交换数据
            int pos = 0;
            for (int j = 0; j < lastPos; j++) {
                if (toSorts[j] > toSorts[j + 1]) {
                    int temp = toSorts[j + 1];
                    toSorts[j + 1] = toSorts[j];
                    toSorts[j] = temp;
                    pos = j;
                    System.out.print("toSorting=" + Arrays.toString(toSorts) + "\n");
                    hasSwitch = true;
                }
                count++;
            }
            lastPos = pos;
            if (!hasSwitch) {
                //若是没有发生过数据交换，则说明队列已经有序
                break;
            }
        }
        System.out.print("count=" + count + "\n");
        System.out.print("toSorts=" + Arrays.toString(toSorts) + "\n");
    }
}
