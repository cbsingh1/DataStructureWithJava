package com.cbsingh.leetcode;

public class LeetCode1051_HeightChecker {

    public static void main(String[] args) {
       //int[] heights = {1,1,4,2,1,3};
       int[] heights = {5,1,2,3,4};

        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int[] map = new int[101]; // heights go from 1 to 100
        for(int h: heights)
            map[h]++;

        int res = 0;
        int h_ptr = 1;

        for(int h: heights) {
            while(map[h_ptr] == 0)
                h_ptr++;
            if(h_ptr != h) {
                res++;
            }
            map[h_ptr]--;
        }
        return res;
    }
}
