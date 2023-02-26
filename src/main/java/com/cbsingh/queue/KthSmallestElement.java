package com.cbsingh.queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinHeapComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer number1, Integer number2) {
        return number2-number1;
    }
}

public class KthSmallestElement {

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3));
    }

    public static int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2-n1);
        for (int a : arr) {
            pq.add(a);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}
