package com.cbsingh.leetcode;

import java.util.Stack;

public class LeetCode121_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int profit=0, max=0;
        for (int i = prices.length-1; i >=0 ; i--) {
            if(prices[i] < max)
                profit = Math.max(profit, max-prices[i]);
            max=Math.max(max, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
