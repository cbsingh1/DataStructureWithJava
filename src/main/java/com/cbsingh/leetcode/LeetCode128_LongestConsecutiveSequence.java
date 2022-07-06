package com.cbsingh.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode128_LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num: nums)
            set.add(num);

        int longestStreak = 0;

        for (int num: nums) {

            if(!set.contains(num-1)) {
                int currentStreak=1;
                int currentNum = num;
                while (set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
