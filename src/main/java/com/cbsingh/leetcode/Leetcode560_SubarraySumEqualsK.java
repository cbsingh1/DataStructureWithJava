package com.cbsingh.leetcode;

import java.util.HashMap;

public class Leetcode560_SubarraySumEqualsK {
    //Time complexity : O(n) The entire nums array is traversed only once.
    //Space complexity : O(n) Hashmap can contain up to n distinct entries in the worst case.
    public int subarraySum(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        var prefixSumFrequency = new HashMap<Integer, Integer>();
        prefixSumFrequency.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            if (prefixSumFrequency.containsKey(prefixSum - k)) {
                count += prefixSumFrequency.get(prefixSum - k);
            }
            prefixSumFrequency.put(prefixSum, prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    //Time complexity : O(n^2)
    public int subarraySum_BruteForce(int[] nums, int k) {
        int result=0;
        for(int i=0; i<nums.length; i++){
            for(int j=i, curr=0; j<nums.length; j++){
                curr += nums[j];
                if(curr==k) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new Leetcode560_SubarraySumEqualsK();

        var result = solution.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println("Result : " + result);
    }
}
