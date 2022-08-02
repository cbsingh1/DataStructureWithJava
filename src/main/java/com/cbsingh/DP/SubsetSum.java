package com.cbsingh.DP;

public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {34, 4, 12, 5, 2};
        //System.out.println(isSubsetPresentRecursive(nums, nums.length, 14));
        System.out.println(isSubsetPresentDP(nums, nums.length, 3));
    }

    private static boolean isSubsetPresentRecursive(int[] nums, int len, int sum) {
        if(sum==0)
            return true;
        if(len==0)
            return false;

        if (nums[len-1]<=sum)
            return (isSubsetPresentRecursive(nums, len-1, sum-nums[len-1])
            || isSubsetPresentRecursive(nums, len-1, sum));
        else
            return isSubsetPresentRecursive(nums, len-1, sum);
    }

    private static boolean isSubsetPresentDP(int[] nums, int len, int sum) {
        boolean [][] matrix = new boolean[len+1][sum+1];

        for (int i = 0; i < len+1; i++)
            matrix[i][0]=true;

        for (int i = 1; i < len+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(nums[i-1] <= j) {
                    matrix[i][j] =  matrix[i-1][j-nums[i-1]] || matrix[i-1][j] ;
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        return matrix[len][sum];
    }
}
