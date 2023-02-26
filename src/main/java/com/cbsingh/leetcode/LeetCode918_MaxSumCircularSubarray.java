package com.cbsingh.leetcode;

public class LeetCode918_MaxSumCircularSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1,2, -3, -2, 6}));
        System.out.println(maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(maxSubarraySumCircular(new int[]{5,-3,5}));
    }

    public static int maxSubarraySumCircular(int[] A) {

        int nonCircularSum = kadaneMaxSum(A);
        int totalSum = 0;
        for(int i=0;i<A.length;i++){
            totalSum += A[i];
            A[i] = -A[i];
        }

        int circularSum = totalSum + kadaneMaxSum(A);
        if(circularSum == 0)
            return nonCircularSum;
        return Math.max(circularSum,nonCircularSum);
    }

    static int kadaneMaxSum(int[] A){
        int currentSum = A[0];
        int maxSum = A[0];
        for(int i=1;i<A.length;i++){
            if(currentSum < 0)
                currentSum = 0;
            currentSum = A[i] + currentSum;
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}

