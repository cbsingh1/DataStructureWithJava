package com.cbsingh.leetcode;

public class LeetCode33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findElement(new int[]{4,5,6,7,0,1,2}, 0));
    }

    private static int findElement(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }
        if(nums[left]==target) return left;
        int leftIndex = binarySearch(nums, 0, left-1, target);
        if(leftIndex==-1)
            return binarySearch(nums,left+1, nums.length-1, target);
        else
            return leftIndex;
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        while (start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] > target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
