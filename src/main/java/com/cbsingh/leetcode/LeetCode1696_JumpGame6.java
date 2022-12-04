package com.cbsingh.leetcode;

public class LeetCode1696_JumpGame6 {
    public static int maxResult(int[] nums, int k) {
        int sum =0;
        int i=0;
        while (i< nums.length) {
            sum += nums[i];
            
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1,-1,-2,4,-7,3},2));
    }
}
