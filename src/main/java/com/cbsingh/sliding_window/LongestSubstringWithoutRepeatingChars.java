package com.cbsingh.sliding_window;

//given string abcabcab, find the longest substring without repeating characters.

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(longestSubstring("abcab"));
    }

    public static int longestSubstring(String input) {
        int len = 0;
        int i=0, j=0, tempCount=0;
        Set<Character> charSet = new HashSet<>();
        while (i<=j && j< input.length()) {
            if(! charSet.add(input.charAt(j)) ) {
                i++;
                charSet = new HashSet<>();
                len = len > tempCount ? len : tempCount;
                tempCount = 0;
            } else {
                j++;
                tempCount++;
            }

        }

        return len;
    }
}
