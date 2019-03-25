package com.tangm.suanfa.sort;

import java.util.Arrays;

/**
 * 快速排序,一次排序过后，key左边数据比key小，key右边数据比key大
 */
public class QuickSort {
    private static int count = 0;

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 9, 8, 100, 5, 200, 19, 2};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
        int[] array3 = DataProvider.generateRandomArray(1000,0,1000);
        System.out.println("经典快排\n");
        int[] result = QuickSort(array3.clone(), 0, 9);
        System.out.println("count=" + count + " " + Arrays.toString(result) + "\n");
        System.out.println("经典快排+三分法\n");
        count = 0;
        result = threePartQuickSort(array3.clone(), 0, 9);
        System.out.println("count=" + count + " " + Arrays.toString(result));
        System.out.println("经典快排+三分法+减少递归层次\n");
        count = 0;
        result = threePartQuickSort(array3.clone(), 0, 9);
        System.out.println("count=" + count + " " + Arrays.toString(result));

    }

    /**
     * 经典快排
     * 时间算法复杂度[O(n*logn),O(n^2)],空间是O(n)
     *
     * @param toSorts
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] toSorts, int start, int end) {
        if (start >= end) {
            return toSorts;
        }
        int first = start;
        int last = end;
        int key = toSorts[first];
        while (first < last) {
            //交换数据，让左边的数据比key小，右边的数据比key大
            while (first < last && toSorts[last] >= key) {
                last--;
                count++;
            }
            toSorts[first] = toSorts[last];
            while (first < last && toSorts[first] <= key) {
                first++;
                count++;
            }
            toSorts[last] = toSorts[first];
        }
        toSorts[first] = key;
        QuickSort(toSorts, start, first - 1);
        QuickSort(toSorts, first + 1, end);
        return toSorts;
    }

    /**
     * 经典快排+三分中法
     * 时间算法复杂度[O(n*logn),O(n^2)],空间是O(n)
     *
     * @param toSorts
     * @param start
     * @param end
     * @return
     */
    public static int[] threePartQuickSort(int[] toSorts, int start, int end) {
        if (start >= end) {
            return toSorts;
        }
        int first = start;
        int last = end;
        int key = findMid(toSorts, first, end);
        while (first < last) {
            //交换数据，让左边的数据比key小，右边的数据比key大
            while (first < last && toSorts[last] >= key) {
                last--;
                count++;
            }
            toSorts[first] = toSorts[last];
            while (first < last && toSorts[first] <= key) {
                first++;
                count++;
            }
            toSorts[last] = toSorts[first];
        }
        toSorts[first] = key;
        QuickSort(toSorts, start, first - 1);
        QuickSort(toSorts, first + 1, end);
        return toSorts;
    }

    /**
     * 从列表的前，中，后数据中，取中间数据
     *
     * @param findList
     * @param low
     * @param high
     * @return
     */
    private static int findMid(int[] findList, int low, int high) {
        int midIndex = (low + high) / 2;
        if (findList[midIndex] > findList[high]) {
            int temp = findList[midIndex];
            findList[midIndex] = findList[high];
            findList[high] = temp;
            //目的mid<=high
        }
        if (findList[low] > findList[high]) {
            int temp = findList[low];
            findList[low] = findList[high];
            findList[high] = temp;
            //目的low<=high
        }
        if (findList[low] < findList[midIndex]) {
            int temp = findList[low];
            findList[low] = findList[midIndex];
            findList[midIndex] = temp;
            //目的是low>=mid
        }
        System.out.print("findMid low=" + findList[low] + " mid=" + findList[midIndex] + " high=" + findList[high] + "\n");
        return findList[low];
    }

    /**
     * 经典快排+三分中法+优化递归
     * 时间算法复杂度[O(n*logn),O(n^2)],空间是O(logn)
     *
     * @param toSorts
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort3(int[] toSorts, int start, int end) {
        if (start >= end) {
            return toSorts;
        }
        int first = start;
        int last = end;
        int key = findMid(toSorts, first, end);
        while (first < last) {
            //交换数据，让左边的数据比key小，右边的数据比key大
            while (first < last && toSorts[last] >= key) {
                last--;
                count++;
            }
            toSorts[first] = toSorts[last];
            while (first < last && toSorts[first] <= key) {
                first++;
                count++;
            }
            toSorts[last] = toSorts[first];
        }
        toSorts[first] = key;
        while (start < end) {
            int privo = (start + end) / 2;
            QuickSort(toSorts, start, privo - 1);
            start = privo + 1;
        }


        return toSorts;
    }

    /**
     * 经典快排+三分中法+优化递归+(<32时)插入排序
     * 时间算法复杂度[O(n*logn),O(n^2)],空间是O(logn)
     *
     * @param toSorts
     * @param start
     * @param end
     * @return
     */
    public static void QuickSort4(int[] toSorts, int start, int end) {
        if (start >= end) {
            return;
        }
        if (end - start < 32) {
            InsertSort.insertSort2(toSorts);
            //插入排序
            return;
        }
        int first = start;
        int last = end;
        int key = findMid(toSorts, first, end);
        while (first < last) {
            //交换数据，让左边的数据比key小，右边的数据比key大
            while (first < last && toSorts[last] >= key) {
                last--;
                count++;
            }
            toSorts[first] = toSorts[last];
            while (first < last && toSorts[first] <= key) {
                first++;
                count++;
            }
            toSorts[last] = toSorts[first];
        }
        toSorts[first] = key;
        while (start < end) {
            int privo = (start + end) / 2;
            QuickSort(toSorts, start, privo - 1);
            start = privo + 1;
        }


        return;
    }

}
