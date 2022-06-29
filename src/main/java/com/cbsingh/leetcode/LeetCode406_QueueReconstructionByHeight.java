package com.cbsingh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode406_QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> queue = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            if(queue.isEmpty())
                queue.add(people[i]);
            else {
                if()
            }
        }

        return queue.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int [][] people = new int[][]{{7,0}, {4,4},{7,1},{5,0},{6,1},{5,2} };

        System.out.println(Arrays.toString(reconstructQueue(people)));
    }
}
