package com.cbsingh.leetcode;

public class Leetcode2187_MinTimeToCompleteTrips {
    public static void main(String[] args) {

        System.out.println(minimumTime(new int[] {1,2,3}, 5));
        System.out.println(minimumTime(new int[] {5,10,10}, 9));
    }
    public static long minimumTime(int[] time, int totalTrips) {
        long  maxTime=0;
        for(int t: time)
            maxTime = Math.max(maxTime, t);
        long left=1, right=maxTime*totalTrips;
        long mid=0;

        while (left<right){
            mid=(left+right)/2;

            if(isTimeEnough(time, totalTrips, mid))
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }

    static boolean isTimeEnough(int[] time, int totalTrips, long givenTime) {
        int actualTrips=0;
        for (int t: time)
            actualTrips += givenTime/t;

        return actualTrips >= totalTrips;
    }
}
