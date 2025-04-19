package com.cbsingh.leetcode;

import java.util.HashMap;

public class Leetcode560_SubarraySumEqualsK {
    //Time complexity : O(n) The entire nums array is traversed only once.
    //Space complexity : O(n) Hashmap chainedHashTable can contain up to n distinct entries in the worst case.
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
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
        assert result == 2;
    }
}
