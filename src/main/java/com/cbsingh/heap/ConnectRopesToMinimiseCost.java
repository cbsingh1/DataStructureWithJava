package com.cbsingh.heap;

import java.util.PriorityQueue;

public class ConnectRopesToMinimiseCost {
    public static void main(String[] args) {
        System.out.println(getMinCostToConnectRopes(new int[] {4,3,2,6}));
        System.out.println(getMinCostToConnectRopes(new int[] {1,2,3}));
    }
    public static int getMinCostToConnectRopes(int[] ropes) {
        int minCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int rope : ropes)
            pq.add(rope);

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            minCost += first + second;
            pq.add(first + second);
        }

        return minCost;
    }
}
