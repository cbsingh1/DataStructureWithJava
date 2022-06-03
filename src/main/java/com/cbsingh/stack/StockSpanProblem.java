package com.cbsingh.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] stockPriceArr = {100, 80, 60, 70, 60, 75, 85};
        //System.out.println(Arrays.toString(computeStockSpanBruteForce(stockPriceArr)));
        System.out.println(Arrays.toString(computeStockSpanWithStack(stockPriceArr)));
    }

    private static int[] computeStockSpanBruteForce(int[] stockPriceArr) {
        int tempArr[] = new int[stockPriceArr.length];

        //Here i is starting with 0 to compute value for 0th position in temp array.
        for (int i = 0; i < stockPriceArr.length; i++) {
            tempArr[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (stockPriceArr[j] < stockPriceArr[i]) {
                    tempArr[i]++;
                } else {
                    break;
                }
            }
        }
        return tempArr;
    }

    public static int[] computeStockSpanWithStack(int[] stockPriceArr) {

        int[] outputArr = new int[stockPriceArr.length];
        Stack<Integer> stack = new Stack<>();

        int h;
        for (int i = 0; i < stockPriceArr.length; i++) {
            while (!stack.isEmpty()) {
                if (stockPriceArr[i] >= stockPriceArr[stack.peek()]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            h = stack.isEmpty() ? -1 : stack.peek();
            outputArr[i] = i - h;
            stack.push(i);
        }
        return outputArr;
    }
}
