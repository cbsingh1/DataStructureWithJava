package com.cbsingh.leetcode;

public class LeetCode605_CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {0, 0, 1, 0, 0};
        int[] flowerbed1 = {0};
        System.out.println(canPlaceFlowers(flowerbed1, 1));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        int len = flowerbed.length;
        int prev=0, next;
        for(int i=0; i<len; i++) {
            next= i<len-1 ? flowerbed[i+1] : 0;
            if(flowerbed[i]==0) {
                if(prev==0 && next==0){
                    flowerbed[i]=1;
                    n--;
                }
                if(n==0) break;
            }
            prev=flowerbed[i];
        }
        return n==0;
    }
}
