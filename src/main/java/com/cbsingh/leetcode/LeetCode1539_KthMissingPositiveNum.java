package com.cbsingh.leetcode;

import java.util.PriorityQueue;

public class LeetCode1539_KthMissingPositiveNum {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        int currentIndex=0, currentNum=1;
        while(pq.size() < k){
            if(currentIndex< arr.length && arr[currentIndex]==currentNum){
                    currentIndex++;
                    currentNum++;
            } else
                pq.add(currentNum++);
        }
        return pq.peek();
    }
}
