package com.cbsingh.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestNumUnsortedArr {
    public static void main(String[] args) {
        FindKClosestNumUnsortedArr obj = new FindKClosestNumUnsortedArr();
        int arr[] = {10, 2, 14, 4, 7, 6};
        System.out.println(obj.findKClosestNumUnsortedArr(arr, 3, 5));
    }
    
    List<Integer> findKClosestNumUnsortedArr(int[] nums, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.getKey() - p1.getKey());
        for(int num : nums) {
            pq.add(new Pair(Math.abs(x-num), num));
            if(pq.size()>k)
                pq.poll();
        }
        List<Integer> resultList = new ArrayList<>();
        while (!pq.isEmpty())
            resultList.add(pq.poll().getValue());

        //Here return value is with max diff, then 2nd diff
        return resultList;
    }

    class Pair {
        int key;
        int val;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return val;
        }
    }
}
