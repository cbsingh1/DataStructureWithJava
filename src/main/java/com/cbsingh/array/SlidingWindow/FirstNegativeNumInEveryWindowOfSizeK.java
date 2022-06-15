package com.cbsingh.array.SlidingWindow;

import java.util.Arrays;

public class FirstNegativeNumInEveryWindowOfSizeK {

    public static void main(String[] args) {
        int []arr = {12,-1, -7, 8, -15, 30, 13, 28};
        int subArraySize = 3;

        System.out.println(Arrays.toString(firstNegativeNumInSubArrayBruteForce(arr, subArraySize)));
        System.out.println(Arrays.toString(firstNegativeNumInSubArray(arr, subArraySize)));
    }

    private static int[] firstNegativeNumInSubArrayBruteForce(int[] arr, int subArraySize) {
        int []returnVal = new int[arr.length -subArraySize + 1];
        int count = 0;
        for (int i = 0; i < arr.length - subArraySize + 1; i++) {
            for (int j = i; j < i+subArraySize; j++) {
                if(arr[j] < 0) {
                    returnVal[count++] = arr[j];
                    break;
                }
            }

        }

        return returnVal;
    }

    private static int[] firstNegativeNumInSubArray(int[] arr, int subArraySize) {
        int []returnVal = new int[arr.length -subArraySize + 1];
        int i=0, j=0, count=0;

        while (j < arr.length) {
            if(j-i+1 == subArraySize){
                while (i<=j){
                    if(arr[i] < 0){
                        returnVal[count++] = arr[i];
                        break;
                    }
                    i++;
                }
            }
            j++;
        }

        return returnVal;
    }
}
