package com.cbsingh.leetcode;

import java.util.Arrays;

public class LeetCode377_CombinationSum4 {


    static int[] dp;

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        //System.out.println(combinationSum4(new int[]{1, 2, 3}, 3));
    }

    public static int combinationSum4(int[] nums, int target) {

/*        dp=new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        helper(nums, target);
        return dp[target];*/


        //other solution

        dp = new int[target+1];
        dp[0] = 1;

        for (int i = 0; i <=target ; i++) {
            for (int n : nums) {
                if(i>=n)
                    dp[i]+=dp[i-n];
            }
        }
        return dp[target];
    }


    static int helper(int[] nums, int target) {
        if (dp[target] > -1)
            return dp[target];
        int result = 0;
        for (int i : nums) {
            if (i <= target)
                result += helper(nums, target - i);
        }
        dp[target] = result;
        return dp[target];
    }
}