package com.cbsingh.leetcode;

public class LeetCode1345_JumpGame4 {
    public static void main(String[] args) {
        //int []arr = {100,-23,-23,404,100,23,23,23,3,404};
        int []arr = {6, 1,9};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        int n= arr.length-1, step=0, i=0;
        while (i < n) {
            step++;
            if(arr[i]==arr[n] || i+1 == n) return step;
            if((i-1 >= 0 && arr[i-1]==arr[n]) || arr[i+1]==arr[n]) return ++step;

            boolean foundMatchingElement= false;
            for (int nextIndex=i+1; nextIndex<n;nextIndex++) {
                if(arr[i]==arr[nextIndex]) {
                    i = nextIndex;
                    foundMatchingElement=true;
                    break;
                }
            }
            if(!foundMatchingElement) i++;
        }
        return step;
    }
}
