package com.tangm.suanfa.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author tony
 * @date 2019/3/4
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = DataProvider.generateRandomArray(10000, 0, 10000);
        System.out.println("插入排序\n");
        long start = System.currentTimeMillis();
        insertSort(array.clone());
        System.out.println("插入排序耗时" + (System.currentTimeMillis() - start) + "\n");
        System.out.println("插入排序2\n");
        start = System.currentTimeMillis();
        insertSort2(array.clone());
        System.out.println("插入排序2耗时" + (System.currentTimeMillis() - start) + "\n");
        System.out.println("希尔排序\n");
        start = System.currentTimeMillis();
        shellSort(array.clone());
        System.out.println("希尔排序耗时" + (System.currentTimeMillis() - start) + "\n");
    }

    /**
     * 插入排序，很像冒泡，但是有所区别，冒泡是每次都将最大或者最小数放到排序头
     * 插入时，每次所要处理的数据，不一定是放在排序头，或者是插到中，前，后都有可能
     * 时间复杂度为O(n^2)
     *
     * @param toSorts
     */
    public static void insertSort(int[] toSorts) {
        int count = 0;
        for (int i = 1; i < toSorts.length; i++) {
            //从1开始，因为只有一个数据时，他本身就是有序的
            for (int j = i - 1; j >= 0; j--) {
                //选择合适的插入位置,a[i]就是待插入数据
                if (toSorts[j + 1] < toSorts[j]) {
                    int temp = toSorts[j + 1];
                    toSorts[j + 1] = toSorts[j];
                    toSorts[j] = temp;
                }
                count++;
            }

        }
        System.out.println("count=" + count + " " + Arrays.toString(toSorts) + "\n");
    }

    /**
     * 插入排序，在之前的基础上优化
     * 由于a[0,i-1]是有序的，若是a[i]与a[i-1]不交换数据，说明a[0,i]也是有序的，那么就无需对比剩下的数据了
     * 时间复杂度为O(n^2)
     *
     * @param toSorts
     */
    public static void insertSort2(int[] toSorts) {
        int count = 0;
        for (int i = 1; i < toSorts.length; i++) {
            //从1开始，因为只有一个数据时，他本身就是有序的
            for (int j = i - 1; j >= 0; j--) {
                //选择合适的插入位置,a[i]就是待插入数据
                if (toSorts[j + 1] < toSorts[j]) {
                    int temp = toSorts[j + 1];
                    toSorts[j + 1] = toSorts[j];
                    toSorts[j] = temp;
                } else {
                    //由于a[0,i-1]是有序的，若是a[i]与a[i-1]不交换数据，说明a[0,i]也是有序的，那么就无需对比剩下的数据了
                    break;
                }
                count++;
            }

        }
        System.out.println("count=" + count + " " + Arrays.toString(toSorts) + "\n");
    }

    /**
     * 希尔排序 https://www.jianshu.com/p/d730ae586cf3
     * 希尔排序是将待排序的数组元素 按下标的一定增量分组 ，分成多个子序列，
     * 然后对各个子序列进行直接插入排序算法排序；然后依次缩减增量再进行排序，
     * 直到增量为1时，进行最后一次直接插入排序，排序结束。
     * <p>
     * <p>
     * 第一个增量=数组的长度/2,
     * 第二个增量= 第一个增量/2,
     * 第三个增量=第二个增量/2,
     * 以此类推，最后一个增量=1。
     * <p>
     * O(n^(1.3—2))
     *
     * @param toSorts
     */
    public static void shellSort(int[] toSorts) {
        int count = 0;
        for (int d = toSorts.length / 2; d >= 1; d = d / 2) {
            for (int i = d; i < toSorts.length; i++) {
                //i是即将要插入的数据，也是一个系列的最后一个数据
                int temp = toSorts[i];
                int j = i - d;
                while (j >= 0 && temp < toSorts[j]) {
                    toSorts[j + d] = toSorts[j];
                    j -= d;
                }
                toSorts[j + d] = temp;
            }
        }
        System.out.println("count=" + count + " " + Arrays.toString(toSorts));
    }
}
