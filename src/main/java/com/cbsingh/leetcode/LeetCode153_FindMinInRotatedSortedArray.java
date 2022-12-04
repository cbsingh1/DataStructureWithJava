package com.cbsingh.leetcode;

public class LeetCode153_FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        //System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{2,1}));
    }

    public static int findMinSolutionWithMinimumLinesOfCode(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }

    public static int findMin(int[] nums) {
        int mid=0, len=nums.length;
        int start=0, end = len-1;
        while (start<=end) {
            if(nums[start] <= nums[end])
                return nums[start];

            mid=start + (end-start)/2;
            int prev = (mid+len-1)% len;
            int next = (mid+1)% len;
            if(nums[mid] < nums[prev] && nums[mid] < nums[next])
                return nums[mid];

            if(nums[mid] <= nums[end])
                end = mid-1;
            else if(nums[start] <= nums[mid])
                start=mid+1;
        }
        return nums[mid];
    }
}
