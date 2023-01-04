package com.cbsingh.heap;

import java.util.*;

public class FindTopK_FrequentNums {
    public static void main(String[] args) {

        FindTopK_FrequentNums classObj = new FindTopK_FrequentNums();

        int[] arr = {1, 1, 1, 3, 2, 2, 4};
        int[] result = classObj.topKFrequent(arr, 2);
        System.out.println(Arrays.toString(result));
    }

    int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int num : nums)
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);

        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(numFrequencyMap::get));

        for (int num : numFrequencyMap.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }

        int[] resultArr = new int[k];
        for (int i = k - 1; i >= 0; --i)
            resultArr[i] = pq.poll();

        return resultArr;
    }
}
