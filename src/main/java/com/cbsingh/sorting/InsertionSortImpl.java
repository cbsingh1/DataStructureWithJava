package com.cbsingh.sorting;

import java.util.Arrays;

public class InsertionSortImpl {

    public static void insertionSort(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            int currElement = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > currElement; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = currElement;
        }
    }

    //Driver program for testing
    public static void main(String[] args) {
        int arr[] = {20, 35, -15, 7, 55, 1, -22};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
