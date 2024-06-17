package com.cbsingh.leetcode;

import java.util.Arrays;

public class LeetCode238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int leftProduct = 1, rightProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] = rightProduct * result[i];
            rightProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new LeetCode238_ProductOfArrayExceptSelf();
        int[] result = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        //Expected output = [24,12,8,6]
        System.out.println(Arrays.toString(result));
    }
}