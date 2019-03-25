package com.tangm.suanfa.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author tony
 * @date 2019/3/5
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = DataProvider.generateRandomArray(10000, 0, 10000);
        System.out.println("直接选择排序\n");
        long start = System.currentTimeMillis();
        selectionSort(array.clone());
        System.out.println("直接选择排序耗时" + (System.currentTimeMillis() - start) + "\n");
        System.out.println("堆排序\n");
        start = System.currentTimeMillis();
        heapSort(array.clone());
        System.out.println("堆排序耗时" + (System.currentTimeMillis() - start) + "\n");
    }

    /**
     * 直接选择排序,每次排序都取得最小值在排序头
     * 算法复杂度是O(n^2)
     *
     * @param toSorts
     */
    private static void selectionSort(int[] toSorts) {
        for (int i = 0; i < toSorts.length - 1; i++) {
            for (int j = i + 1; j < toSorts.length; j++) {
                if (toSorts[j] < toSorts[i]) {
                    int temp = toSorts[j];
                    toSorts[j] = toSorts[i];
                    toSorts[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(toSorts));
    }

    /**
     * 堆排序 https://www.cnblogs.com/chengxiao/p/6129630.html
     * <p>
     * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
     * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
     * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
     *
     * O (nlgn)
     *
     * @param toSorts
     */
    public static void heapSort(int[] toSorts) {
        //构建最大堆
        //从第一个非叶子节点开始,length/2-1
        for (int i = toSorts.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构,成为最大堆
            adjustMaxHeap(toSorts, i, toSorts.length);
        }
        //交换栈顶和最后一个数据，再次构建最大堆
        for (int j = toSorts.length - 1; j > 0; j--) {
            int temp = toSorts[j];
            toSorts[j] = toSorts[0];
            toSorts[0] = temp;
            adjustMaxHeap(toSorts, 0, j);
        }
        System.out.println(Arrays.toString(toSorts));
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param toSorts
     * @param parentIndex
     * @param length
     */

    public static void adjustMaxHeap(int[] toSorts, int parentIndex, int length) {
        int temp = toSorts[parentIndex];
        for (int son = parentIndex * 2 + 1; son < length; son = son * 2 + 1) {
            if (son + 1 < length && toSorts[son] < toSorts[son + 1]) {
                son++;
                //发现左子节点比右节点点小，移动索引到右子节点
            }
            if (toSorts[son] > temp) {
                //发现右子节点比父节点大，不符合最大堆特性，将右子节点移到父节点
                toSorts[parentIndex] = toSorts[son];
                parentIndex = son;
            } else {
                break;
            }

        }
        toSorts[parentIndex] = temp;
    }

}
