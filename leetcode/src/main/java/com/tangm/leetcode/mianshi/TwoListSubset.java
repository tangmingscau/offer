package com.tangm.leetcode.mianshi;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;


/**
 * 腾讯的现场现场面试题
 * <p>
 * 求两个数组的的交集
 * <p>
 * <p>
 * 感言：现场写的时候脑子短路了，想了大概两分钟都想不出答案，就暴力两个for循环
 * <p>
 * 结果：面试结束后，冷风一吹，用hash呀，一个很简单o(m+n)的算法，恨呀，没办法，面挂了，哎
 * 谁叫当时脑子短路呀，此恨绵绵,就几分钟的差距
 *
 * @author tony
 * @date 2019/4/9
 */
public class TwoListSubset {
    public static void main(String[] args) {
        hashSubSet(new int[]{2, 3, 4}, new int[]{3, 4, 5});
    }

    public static void hashSubSet(int[] num1, int[] num2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < num1.length; i++) {
            hashMap.put(num1[i], 1);
        }
        Queue<Integer> queue = new ArrayDeque<>();//用来存储交集
        for (int i = 0; i < num2.length; i++) {
            if (hashMap.containsKey(num2[i])) {
                queue.add(num2[i]);
            }
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
