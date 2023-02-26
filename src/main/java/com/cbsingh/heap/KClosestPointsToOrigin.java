package com.cbsingh.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {

        KClosestPointsToOrigin classObj = new KClosestPointsToOrigin();

        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        int[][] result = classObj.kClosest(points,2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + ", " + result[i][1]);
        }
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = pq.poll();
        }
        return res;
    }


}
