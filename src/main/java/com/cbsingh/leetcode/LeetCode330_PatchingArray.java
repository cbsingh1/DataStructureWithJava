package com.cbsingh.leetcode;

public class LeetCode330_PatchingArray {
    public int minPatches(int[] nums, int n) {
        int patches = 0, curr = 1, i=0;
        while (curr <= n) {
            if(i<nums.length && nums[i] <= curr){
                curr += nums[i++];
            } else {
                curr += curr;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        var solution = new LeetCode330_PatchingArray();
        int result = solution.minPatches(new int[]{1, 5, 10}, 20);

        System.out.println(result);
    }
}
