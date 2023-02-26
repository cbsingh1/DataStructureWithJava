package com.cbsingh.leetcode;

public class LeetCode1584_MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int [][] points = {{0,0}, {2,2}, {3,10}, {5,2}, {7,0}};
        System.out.println(minCostConnectPoints(points));
    }
    public static int minCostConnectPoints(int[][] points) {
        int minCost =0;

        for (int i = 0; i < points.length-1; i++) {
            int levelMin=Integer.MAX_VALUE;
            for (int j = i+1; j < points.length; j++) {
                int levelCost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                if(levelMin > levelCost)
                    levelMin = levelCost;
            }
            minCost += levelMin;
        }

        return minCost;
    }
}
