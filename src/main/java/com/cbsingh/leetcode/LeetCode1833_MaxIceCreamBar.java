package com.cbsingh.leetcode;

import java.util.Arrays;

public class LeetCode1833_MaxIceCreamBar {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1,3,2,4,1}, 7));
        System.out.println(maxIceCream(new int[]{10,6,8,7,7,8}, 5));
    }
    public static int maxIceCream(int[] costs, int coins) {
        int result = 0;
        Arrays.sort(costs);
        for (int cost: costs) {
            if(cost > coins) break;
            coins -= cost;
            result++;
        }
        return result;
    }
}
