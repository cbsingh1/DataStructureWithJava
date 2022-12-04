package com.cbsingh.leetcode;

public class LeetCode458_PoorPigs {
    public static void main(String[] args) {

        //System.out.println(poorPigs(1000, 15,60));
        System.out.println(poorPigs(4, 15,30));
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets-- == 1) {
            return 0;
        }
        int base = minutesToTest/minutesToDie + 1;
        int res = 0;
        while (buckets > 0) {
            buckets = buckets/base;
            res += 1;
        }
        return res;
    }
}
