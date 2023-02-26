package com.cbsingh.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FindTopK_FrequentNums_QuickSelectAlgo {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    int[] uniqueArr;
    public static void main(String[] args) {
        FindTopK_FrequentNums_QuickSelectAlgo classObj = new FindTopK_FrequentNums_QuickSelectAlgo();

        int[] arr = {1, 1, 1, 3, 2, 2, 4};
        int[] result = classObj.topKFrequent(arr, 2);
        System.out.println(Arrays.toString(result));
    }

    public int[] topKFrequent(int[] nums, int k) {
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);

        int n = frequencyMap.size();
        uniqueArr = new int[n];

        int index=0;
        for (int num:frequencyMap.keySet())
            uniqueArr[index++] = num;

        quickSelect(0, n-1, n-k);

        return Arrays.copyOfRange(uniqueArr, n - k, n);
    }

    private void quickSelect(int left, int right, int k_smallest) {

        if(left==right)
            return;

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickSelect(left, pivot_index - 1, k_smallest);
        } else {
            // go right
            quickSelect(pivot_index + 1, right, k_smallest);
        }
    }

    private int partition(int left, int right, int pivotIndex) {
        int pivotFrequency = frequencyMap.get(uniqueArr[pivotIndex]);
        int storeIndex=left;

        for (int i=left; i<right; i++) {
            if(frequencyMap.get(uniqueArr[i]) < pivotFrequency) {
                swap(storeIndex,i);
                storeIndex++;
            }
        }
        swap(storeIndex, right);
        return storeIndex;
    }

    private void swap(int t1, int t2) {
        int temp=uniqueArr[t1];
        uniqueArr[t1]=uniqueArr[t2];
        uniqueArr[t2]=temp;
    }
}
