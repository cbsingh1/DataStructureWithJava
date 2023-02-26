package com.cbsingh.searching;

public class FindCountOfElementInSortedArr {
    public static void main(String[] args) {
        System.out.println(findElementCount(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(findElementCount(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println(findElementCount(new int[]{}, 0));
    }

    public static int findElementCount(int[] arr, int target) {
        int left = binarySearch(arr, target, true);
        if (left < 0) return 0;
        int right = binarySearch(arr, target, false);
        return right - left + 1;
    }

    private static int binarySearch(int[] arr, int target, boolean leftmost) {
        int lo = 0;
        int hi = arr.length - 1;
        int idx = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // avoid overflow. same as (lo + hi) / 2
            if (target > arr[mid])
                lo = mid + 1;
            else if (target < arr[mid])
                hi = mid - 1;
            else {
                idx = mid;
                if (leftmost)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
        }
        return idx;
    }
}
