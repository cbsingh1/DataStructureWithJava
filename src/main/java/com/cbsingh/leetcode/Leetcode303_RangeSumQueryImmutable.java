package com.cbsingh.leetcode;

import java.util.Arrays;

public class Leetcode303_RangeSumQueryImmutable {
    public static void main(String[] args) {
        test(new int[]{-2, 0, 3, -5, 2, -1}, 1,2);
    }

    int[] prefix;

    public Leetcode303_RangeSumQueryImmutable(int[] nums) {
        prefix = new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0
                ? prefix[right]
                : prefix[right]-prefix[left-1];

    }

    static void test(int[] nums, int left, int right) {
        var cut = new Leetcode303_RangeSumQueryImmutable(nums);
        System.out.println("Nums: " + Arrays.toString(nums) + "-" + left + " - " + right);
        System.out.println("Result: " + cut.sumRange(left, right));
        System.out.println("---------------");
    }
}