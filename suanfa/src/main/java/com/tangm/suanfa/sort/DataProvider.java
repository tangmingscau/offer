package com.tangm.suanfa.sort;

/**
 * @author tony
 * @date 2019/3/5
 */
public class DataProvider {
    public static int[] generateRandomArray(int n, int rangL, int rangR) {

        assert rangL <= rangR;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangR - rangL + 1) + rangL);
        }
        return arr;
    }

}
