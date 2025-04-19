package com.cbsingh.leetcode;

import java.util.HashSet;

public class LeetCode217_ContainsDuplicate {
    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 1}); //answer = true
        test(new int[]{1, 2, 3, 4}); //answer = false

    }

    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;

        // Alternative solution - 1 line
        // return Arrays.stream(nums).distinct().count() < nums.length;
    }

    static void test(int[] input) {
        var cut = new LeetCode217_ContainsDuplicate();

        System.out.println("Input: " + input);
        System.out.println("Result: " + cut.containsDuplicate(input));
        System.out.println("---------------");
    }
}
