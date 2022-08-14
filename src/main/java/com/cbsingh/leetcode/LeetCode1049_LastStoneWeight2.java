package com.cbsingh.leetcode;

public class LeetCode1049_LastStoneWeight2 {
    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        System.out.println(lastStoneWeightII(new int[]{31,26,33,21,40}));
    }

    public static int lastStoneWeightII(int[] stones) {

        if(stones.length==0) return 0;
        if(stones.length==1) return stones[0];

        int sum=0, diff=Integer.MAX_VALUE;
        for (int stone: stones)
            sum += stone;

        for (int i = 0; i <= sum/2 ; i++) {
            if(checkSubsetWithGivenSum(stones, i)){
                diff = Math.min(diff, sum - 2*i);
            }
        }
        return diff;
    }

    private static boolean checkSubsetWithGivenSum(int[] stones, int sum) {
        int n = stones.length;
        boolean [][] matrix = new boolean[n+1][sum+1];

        for (int i = 0; i < matrix.length; i++)
            matrix[i][0] = true;

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=sum; j++) {

                if(stones[i-1]<=j)
                    matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-stones[i-1]];
                else
                    matrix[i][j] = matrix[i-1][j];
            }
        }

        return matrix[n][sum];
    }
}
