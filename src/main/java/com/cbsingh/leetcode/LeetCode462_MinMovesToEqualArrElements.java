package com.cbsingh.leetcode;

import java.util.Arrays;

public class LeetCode462_MinMovesToEqualArrElements {
    public static int minMoves2(int[] nums) {
        int steps=0, i=0, j=nums.length-1;
        Arrays.sort(nums);
        while (i < j)
            steps += nums[j--] - nums[i++];
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(minMoves2(new int[] {1,0,0,6,8}));
        System.out.println(minMoves2(new int[] {1,2,3}));
        System.out.println(minMoves2(new int[] {1,10,2,9}));
        System.out.println(minMoves2(new int[] {203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143}));
    }
}
