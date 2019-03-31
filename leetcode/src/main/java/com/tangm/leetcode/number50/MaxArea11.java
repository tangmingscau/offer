package com.tangm.leetcode.number50;

/**
 * @author tony
 * @date 2019/3/30
 */
public class MaxArea11 {
    static int[] s1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

    public static void main(String[] args) {
        System.out.println(maxArea(s1));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        //穷举法，算出每个容器作为最左的边能承载的最大水容量,算法复杂度是O(n^2+n)

        //算法复杂度过高,leetcode过不去,超出时间限制
        int[] maxAreas = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempArea = Math.min(height[i], height[j]) * (j - i);
                if (tempArea > maxAreas[i]) {
                    maxAreas[i] = tempArea;
                }
            }
        }
        int max = maxAreas[0];
        for (int i = 0; i < maxAreas.length; i++) {
            if (maxAreas[i] > max) {
                max = maxAreas[i];
            }
        }
        return max;
    }
}
