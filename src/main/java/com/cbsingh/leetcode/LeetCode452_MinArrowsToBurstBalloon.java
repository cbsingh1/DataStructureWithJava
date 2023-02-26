package com.cbsingh.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452_MinArrowsToBurstBalloon {
    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length==0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int arrowShots=1;
        int end=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>end){
                arrowShots++;
                end = points[i][1];
            }
        }
        return arrowShots;
    }
}
