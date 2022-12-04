package com.cbsingh.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public static void main(String[] args) {
        int arr[] = {6,5,3,2,8,10,9};
        int[] sortedArr = sortNearlySortedArr(arr, 4);
        System.out.println(Arrays.toString(sortedArr));
    }

    static int[] sortNearlySortedArr(int[] arr, int k) {
        int resultArr[] = new int[arr.length];
        int index=0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : arr) {
            pq.add(num);
            if(pq.size() > k)
                resultArr[index++] = pq.poll();
        }
        while (! pq.isEmpty())
            resultArr[index++] = pq.poll();

        return resultArr;
    }
}
