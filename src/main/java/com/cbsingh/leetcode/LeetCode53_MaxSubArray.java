package com.cbsingh.leetcode;

public class LeetCode53_MaxSubArray {
    //Using Kadane's algorithm (https://www.youtube.com/watch?v=86CQq3pKSUw)
    //Time complexity: O(n)
    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static int maxSubArraySolution2(int[] nums) {
        int maxSum=Integer.MIN_VALUE, fast=0,currentSum=0;

        while (fast < nums.length) {
            currentSum += nums[fast];
            if(nums[fast] > currentSum)
                currentSum=nums[fast];
            if(currentSum > maxSum)
                maxSum=currentSum;
            fast++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-2, 1}));
    }
}
