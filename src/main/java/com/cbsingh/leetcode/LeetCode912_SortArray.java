package com.cbsingh.leetcode;

import java.util.Arrays;

public class LeetCode912_SortArray {
    public static void main(String[] args) {
        LeetCode912_SortArray obj = new LeetCode912_SortArray();

        int nums[] = {5,2,3,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(obj.sortArray(nums)));
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    static void quickSort(int[] nums, int l, int r) {
        if(l>=r)
            return;
       int p = partition(nums, l, r);
       quickSort(nums, l, p-1);
       quickSort(nums, p+1, r);
    }

    static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i=l-1;
        for (int j = l; j < r; j++) {
            if(nums[j] < pivot) {
                i += 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
