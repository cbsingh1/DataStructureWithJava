package com.cbsingh.DP;

public class MinSubsetSumDiff {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{-36, 36}));
    }

    public static int minimumDifference(int[] nums) {

        if(nums.length < 1)
            return -1;
        if(nums.length == 1)
            return nums[1];

        int sum=0, diff=Integer.MAX_VALUE;
        for (int n : nums)
            sum += n;

        for (int i = 0; i <= sum/2; i++) {
            if(checkSubsetWithGivenSum(nums, i))
                diff = Math.min(diff, sum-2*i);
        }

        return diff;
    }

    private static boolean checkSubsetWithGivenSum(int[] nums, int sum) {
        int n =nums.length;
        boolean [][]matrix = new boolean[n+1][sum+1];

        for (int i = 0; i < matrix.length; i++)
            matrix[i][0] = true;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j <=sum ; j++) {
                if(nums[i-1]<=j)
                    matrix[i][j]= matrix[i-1][j] || matrix[i-1][j-nums[i-1]];
                else
                    matrix[i][j]= matrix[i-1][j];
            }
        }

        return matrix[n][sum];
    }
}
