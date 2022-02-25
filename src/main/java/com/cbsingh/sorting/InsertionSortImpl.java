package com.cbsingh.sorting;

import java.util.Arrays;

public class InsertionSortImpl {

    public static void insertionSort(int arr[]) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int currElement = arr[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > currElement; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = currElement;
        }
    }

    public static void insertionSortRecursiveApproach(int input[], int numItems) {
        if(numItems < 2)
            return;

        insertionSortRecursiveApproach(input, numItems-1);

        int newElement = input[numItems-1];
        int j;
        for (j = numItems-1; j > 0 && input[j-1] > newElement; j--) {
            input[j]=input[j-1];
        }
        input[j] = newElement;
    }

    //Driver program for testing
    public static void main(String[] args) {
        int arr[] = {20, 35, -15, 7, 55, 1, -22};
        //insertionSort(arr);
        insertionSortRecursiveApproach(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
