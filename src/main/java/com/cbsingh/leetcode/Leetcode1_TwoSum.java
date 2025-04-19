package com.cbsingh.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode1_TwoSum {
    public static void main(String[] args) {
        test(new int[]{2, 7, 11, 15}, 9);
        test(new int[]{3, 2, 4}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        var indexMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                return new int[]{i, indexMap.get(complement)};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{};
    }

    static void test(int[] nums, int target) {
        Leetcode1_TwoSum cut = new Leetcode1_TwoSum();
        var result = cut.twoSum(nums, target);
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("---------------");
    }
}