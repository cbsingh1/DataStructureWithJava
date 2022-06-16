package com.cbsingh.array.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstNegativeNumInEveryWindowOfSizeK {

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 13, 28};
        int subArraySize = 3;

        System.out.println(Arrays.toString(firstNegativeNumInSubArrayBruteForce(arr, subArraySize)));
        System.out.println(Arrays.toString(firstNegativeNumInSubArray(arr, subArraySize)));
        System.out.println(Arrays.toString(firstNegativeNumInSubArrayUsingList(arr, subArraySize)));
    }

    //Time complexity - O (nk)
    private static int[] firstNegativeNumInSubArrayBruteForce(int[] arr, int subArraySize) {
        int[] negativeFirstValArr = new int[arr.length - subArraySize + 1];
        int count = 0;
        for (int i = 0; i < arr.length - subArraySize + 1; i++) {
            for (int j = i; j < i + subArraySize; j++) {
                if (arr[j] < 0) {
                    negativeFirstValArr[count++] = arr[j];
                    break;
                }
            }

        }

        return negativeFirstValArr;
    }

    // Time complexity - O(n)
    private static int[] firstNegativeNumInSubArray(int[] arr, int subArraySize) {
        int[] negativeFirstValArr = new int[arr.length - subArraySize + 1];
        int i = arr.length - 1, j = arr.length - 1, count = negativeFirstValArr.length-1, negativeNumIndex = -1;

        while (i >= 0) {
            if (arr[i] < 0)
                negativeNumIndex = i;

            if (j - i + 1 == subArraySize) {

                if(negativeNumIndex == -1 || !(i <= negativeNumIndex && negativeNumIndex <= j))
                    negativeFirstValArr[count--] = 0;
                else
                    negativeFirstValArr[count--] = arr[negativeNumIndex];
                j--;
            }
            i--;
        }
        return negativeFirstValArr;
    }

    //Time complexity - O(n) , Auxiliary space - O(k)
    private static int[] firstNegativeNumInSubArrayUsingList(int[] arr, int subArraySize) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] negativeFirstValArr = new int[arr.length - subArraySize + 1];
        int i = 0, j = 0, count = 0;

        while (j < arr.length) {
            if (arr[j] < 0)
                list.add(arr[j]);

            if (j-i+1 == subArraySize) {
                if(list.isEmpty())
                    negativeFirstValArr[count++] = 0;
                else{
                    negativeFirstValArr[count++] = list.get(0);
                    if(list.contains(arr[i]))
                        list.remove(0);
                }
                i++;
            }
            j++;
        }
        return negativeFirstValArr;
    }
}
