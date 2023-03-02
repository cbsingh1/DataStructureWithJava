package com.cbsingh.leetcode;

import java.util.HashMap;

public class LeetCode409_LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }

    public static int longestPalindrome(String s) {
        int result = 0;
        var charCountMap = new HashMap<Character, Integer>();
        for (Character c : s.toCharArray())
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);

        for (Integer i : charCountMap.values()) {
            if (i % 2 == 0) result += i;
            else result += i - 1;
        }
        return (s.length() % 2 == 0) ? result : result + 1;
    }
}
