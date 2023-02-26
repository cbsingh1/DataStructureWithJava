package com.cbsingh.leetcode;

public class LeetCode926_FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
    }

    public static int minFlipsMonoIncr(String s) {
        int onesCount =0, flipCount=0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0') {
                if(onesCount==0) continue;
                flipCount++;
            }
            else if(s.charAt(i)=='1')
                onesCount++;

            if(flipCount > onesCount)
                flipCount=onesCount;
        }

        return flipCount;
    }
}
