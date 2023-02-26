package com.cbsingh.leetcode;

import java.util.PriorityQueue;

public class LeetCode1675_MinDeviationArr {
    public static void main(String[] args) {
        //System.out.println(minimumDeviation(new int[] {4,1,5,20,3}));
        System.out.println(minimumDeviation(new int[]{3,5}));
    }

    public static int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 1) num = num * 2;
            min = Math.min(min, num);
            pq.add(num);
        }

        int diff = Integer.MAX_VALUE;
        while (pq.peek()%2==0) {
            int max = pq.remove();
            diff=Math.min(diff, max-min);
            min = Math.min(min, max/2);
            pq.add(max/2);
        }
        return Math.min(diff, pq.peek()-min);
    }
}
