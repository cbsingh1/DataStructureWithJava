package com.cbsingh.leetcode;

import java.util.*;

public class LeetCode1636_SortArrByIncreasingFrequency {
    public static void main(String[] args) {
        int nums[] = {2,3,1,3,2};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n->map.put(n, map.getOrDefault(n, 0)+1));

        return Arrays.stream(nums).boxed()
                .sorted((n1,n2) -> map.get(n1)==map.get(n2)?n2-n1:map.get(n1)-map.get(n2))
                .mapToInt(n -> n)
                .toArray();
    }
}
