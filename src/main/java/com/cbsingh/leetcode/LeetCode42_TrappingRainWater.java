package com.cbsingh.leetcode;

public class LeetCode42_TrappingRainWater {
    public static void main(String[] args) {
        int []height = {3,0,0,2,0,4};

        System.out.println(new LeetCode42_TrappingRainWater().trap(height));
    }

    public int trap(int[] height) {

        if(height ==null || height.length ==0)
            return 0;
        int totalWater = 0;
        int waterLevel = 0;
        int []rightMaxArr = new int[height.length];
        rightMaxArr[rightMaxArr.length-1] =height[height.length-1];
        int maxLeft = 0;
        for (int i = height.length-2; i >=0; i--)
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i+1]);
        for (int i = 1; i < height.length; i++) {
            if(height[i-1] > maxLeft)
                maxLeft=height[i-1];
            waterLevel= Math.min(maxLeft, rightMaxArr[i]);
            if(height[i] < waterLevel)
                totalWater += waterLevel - height[i];
        }
        return totalWater;
    }
}
