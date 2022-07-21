package com.cbsingh.leetcode;

public class LeetCode1482_MinNumOfDaysToMakeBouquets {

    public static void main(String[] args) {
       // System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 1));
       //System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;

        int min=Integer.MAX_VALUE, max=0;
        for (int day : bloomDay) {
            if(day<min)
                min = day;
            if(day>max)
                max = day;
        }
        int left = min, right = max;

        while (left < right) {
            int mid = (left + right) / 2, flow = 0, bouq = 0;
            for (int j = 0; j < n; ++j) {
                if (bloomDay[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
