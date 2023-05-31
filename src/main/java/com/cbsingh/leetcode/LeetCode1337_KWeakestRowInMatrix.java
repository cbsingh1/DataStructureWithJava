package com.cbsingh.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode1337_KWeakestRowInMatrix {

    public static void main(String[] args) {
        int [][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[] result = kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(result));
    }

    //Solution using binarySearch & Priority Queue
    /* Time complexity :

        (A) Finding strength :
        Find strength of each row : O(log n)
        Total m rows, for M rows, complexity would be : O(m log n)

        B(Inserting into PQ)
        Inserting element into Priority Queue : O(log k)
        We have m rows, so total : O(m logk)

        Total : A +B
         = m log.n + m log.k
         = m(log.n + log.k)
         = m log.nk

         Spance : O(k) -> for priority queue

     */

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0]==b[0])
                return b[1]-a[1];
            else
                return b[0]-a[0];
        });

        for(int i=0; i<m; i++){
            int strength= binarySearch(mat[i]);
            int[] entry = new int[] {strength, i};
            pq.add(entry);
            if(pq.size() > k)
                pq.poll();
        }
        int[] resultArr = new int[k];
        for(int i=k-1; i>=0; i--){
            int[] pair = pq.poll();
            resultArr[i] = pair[1];
        }
        return resultArr;
    }

    static int binarySearch(int[] row) {
        int left=0;
        int right=row.length;

        while(left < right) {
            int mid = left + (right-left)/2;
            if(row[mid]==1)
                left=mid+1;
            else
                right = mid;
        }
        return left;
    }
}
