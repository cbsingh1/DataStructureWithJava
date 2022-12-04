package com.cbsingh.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosetNumbers {
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6};
        //System.out.println(findClosestElements(arr, 1, 9));
        System.out.println(findClosestElements(arr, 3, 4));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
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
}
