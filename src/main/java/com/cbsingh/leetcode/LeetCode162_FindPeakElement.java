package com.cbsingh.leetcode;

public class LeetCode162_FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(findPeakElement(new int[]{1, 2}));
        System.out.println(findPeakElement(new int[]{2, 1}));
    }

    public static int findPeakElement(int[] nums) {

        if (nums.length == 1) return 0;
        int start = 0, end = nums.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                    return mid;
                else if (nums[mid + 1] > nums[mid])
                    start = mid + 1;
                else if (nums[mid - 1] > nums[mid])
                    end = mid - 1;
            }
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1])
                    return mid;
                else
                    return mid + 1;
            }
            if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1])
                    return mid;
                else
                    return mid - 1;
            }
        }
        return mid;
    }
}
