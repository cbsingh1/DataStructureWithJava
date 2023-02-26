package com.cbsingh.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1647_MinDeletionToMakeCharFreqUnique {

    public static int minDeletions(String s) {
        int deletionCount = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character ch : s.toCharArray())
            charMap. put(ch, charMap.getOrDefault(ch, 0)+1);
        ArrayList<Integer> al = new ArrayList();
        for (Integer value : charMap.values().stream().sorted((a,b) -> b-a).toList()) {
            while (al.contains(value)) {
                value--;
                deletionCount++;
            }
            if(value > 0) al.add(value);
        }
        return deletionCount;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));
    }
}
