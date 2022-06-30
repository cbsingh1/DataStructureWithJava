package com.cbsingh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode406_QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        for(int []p : people)
            list.add(p[1], p);

        return list.toArray(new int[people.length][2]);
    }


    public static void main(String[] args) {
        int [][] people = new int[][]{{7,0}, {4,4},{7,1},{5,0},{6,1},{5,2} };
        int [][] people1 = new int[][]{{6,0},{5,0}, {4,0},{3,2},{2,2},{1,4}};
        //int [][] people = new int[][]{{7,0}, {4,4} };

        int [][] output=  reconstructQueue(people1);

        for (int i = 0; i < output.length; i++) {
            System.out.println(Arrays.toString(output[i]));
        }

    }

}
