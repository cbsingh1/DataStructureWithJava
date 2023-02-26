package com.cbsingh.leetcode;

import java.util.Stack;

/**
 * LeetCode Problem: https://leetcode.com/problems/online-stock-span/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<int[]>(); // (price, span)
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price)
            span += stack.pop()[1];

        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        int[] prices = {100,80,60,70,60,75,85};

        for (int price : prices) {
            System.out.println(obj.next(price)) ;
        }

    }
}
