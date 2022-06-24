package com.cbsingh.leetcode;

import java.util.*;

/*You are given an array target of n integers. From a starting array arr consisting of n 1's, you may perform the following procedure :

        let x be the sum of all elements currently in your array.
        choose index i, such that 0 <= i < n and set the value of arr at index i to x.
        You may repeat this procedure as many times as needed.
        Return true if it is possible to construct the target array from arr, otherwise, return false.*/

public class LeetCode1354_ConstructTargetArrayWithMultipleSum {

    public static boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            pq.offer(target[i]);
        }
        while (pq.peek() != 1) {
            int value = pq.poll();
            long diff = sum - value;
            if(diff == 1) return true;
            if(diff > value || diff ==0 || value%diff==0 ) return false;
            value %= diff;
            sum = diff + value;
            pq.offer(value);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[] {9,3,5}));
        System.out.println(isPossible(new int[] {1,1,1,2}));
        System.out.println(isPossible(new int[] {8,5}));
        System.out.println(isPossible(new int[] {1,1,2}));
    }
}
