package com.cbsingh.DP;

public class CountOfSubsetSumWithGivenSum {
    public static void main(String[] args) {
        System.out.println(countSubsets(new int[]{2,3,5,6,8,10}, 9));
    }

    private static int countSubsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] matrix = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++)
            matrix[i][0]=1;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j <sum+1 ; j++) {
                if(nums[i-1]<=j)
                    matrix[i][j] = matrix[i-1][j-nums[i-1]] + matrix[i-1][j];
                else
                    matrix[i][j] = matrix[i-1][j];
            }
        }

        return matrix[n][sum];
    }
}
