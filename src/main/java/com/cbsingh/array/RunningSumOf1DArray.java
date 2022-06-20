package com.cbsingh.array;

import java.util.Arrays;

public class RunningSumOf1DArray {
    private static int[] calcRunningSumOfArray(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(calcRunningSumOfArray(arr)));
    }
}
