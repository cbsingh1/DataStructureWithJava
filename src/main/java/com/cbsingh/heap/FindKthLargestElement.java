package com.cbsingh.heap;

import java.util.PriorityQueue;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int []arr = {7,10,4,3,20,15};
        System.out.println(findKLargest(arr, 3));
    }

    static int findKLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums ) {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.size() > 0 ? pq.peek() : -1;
    }
}
