package com.cbsingh.sorting;

import java.util.Arrays;

public class SelectionSortImpl {

    public static int[] sort(int arr[]) {

        for (int lastUnsortedIndex= arr.length-1; lastUnsortedIndex >0; lastUnsortedIndex--) {

            int maxIndex = 0;

            for (int i = 1; i <=lastUnsortedIndex ; i++) {
                if (arr[i] > arr[maxIndex])
                    maxIndex = i;
            }

            swap(arr, maxIndex, lastUnsortedIndex);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {

        if (i == j) return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr1[] = {20,35,-15, 7,55,1,-22};
        System.out.println(Arrays.toString(sort(arr1)));
    }
}
