package com.cbsingh.heap;

import java.util.PriorityQueue;

public class FindKthSmallestElement {
    public static void main(String[] args) {
        int []arr = {7,10,4,3,20,15};
        System.out.println(findKthSmallestElement(arr, 3));
    }

    static int findKthSmallestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int num : nums ) {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.size() > 0 ? pq.peek() : -1;
    }
}
