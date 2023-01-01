package com.cbsingh.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestNumbersSortedArr {
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6};

        //System.out.println(findClosestElementsUsing2Pointers(arr, 3, 4));
        System.out.println(findClosestElementsBinarySearch(arr, 3, 4));
    }

    public static List<Integer> findClosestElementsUsing2Pointers(int[] arr, int k, int x) {
        int low=0, high = arr.length -1;
        while(high-low >= k) {
            if(Math.abs(x-arr[low]) > Math.abs(x-arr[high]))
                low++;
            else
                high--;
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = low; i <= high; i++)
            al.add(arr[i]);
        return al;
    }

    public static List<Integer> findClosestElementsBinarySearch(int[] arr, int k, int x) {
        int left=0, right= arr.length-k;

        while (left<right) {
            int mid = (left+right)/2;
            if(x-arr[mid] > arr[mid+k]-x)
                left = mid+1;
            else
                right =mid;
        }

        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    }
}
