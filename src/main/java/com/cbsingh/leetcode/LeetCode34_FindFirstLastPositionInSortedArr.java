package com.cbsingh.leetcode;

import java.util.Arrays;

public class LeetCode34_FindFirstLastPositionInSortedArr {

    public static int[] searchRange(int[] nums, int target) {
        int firstIndex=-1, lastIndex=-1;
        if(nums.length==1) {
            if(nums[0]==target)
                firstIndex=lastIndex=0;
        }
        if(nums.length > 1) {
            int start = 0, end=nums.length-1, subArrStart=0, subArrEnd= nums.length;
            while (start<=end){
                int mid = start + (end-start)/2;
                if(nums[mid]==target) {
                    firstIndex=mid;
                    end=mid-1;
                } else if (nums[mid]>target)
                    end=mid-1;
                else
                    start=mid+1;
            }
            lastIndex=firstIndex;
            start = firstIndex+1;
            end = nums.length-1;
            while (start<=end){
                int mid = start + (end-start)/2;
                if(nums[mid]==target) {
                    lastIndex=mid;
                    start=mid+1;
                } else if (nums[mid]>target)
                    end=mid-1;
                else
                    start=mid+1;
            }
        }
        return new int[]{firstIndex, lastIndex};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},6)));
        System.out.println(Arrays.toString(searchRange(new int[]{},0)));
    }
}
