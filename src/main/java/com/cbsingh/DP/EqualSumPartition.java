package com.cbsingh.DP;

public class EqualSumPartition {
    public static void main(String[] args) {
        //System.out.println(canPartition(new int[]{1,5,11,5}));
        //System.out.println(canPartition(new int[]{1,2,3,5}));
        System.out.println(canPartition(new int[]{3,3,3,4,5}));
        //System.out.println(canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
    }

    public static boolean canPartition(int[] nums) {
        int sum=0;
        for (int num: nums)
            sum += num;

        if(sum%2 != 0)
            return false;
        else
            return isSubsetPresentDP(nums, nums.length, sum/2);
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
