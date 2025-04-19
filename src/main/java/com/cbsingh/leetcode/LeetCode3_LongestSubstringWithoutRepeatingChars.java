package com.cbsingh.leetcode;

import java.util.HashSet;

public class LeetCode3_LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        test("abcabcbb"); //answer = 3 (i.e. abc)
        test("bbbbb"); //answer = 1 (i.e. b)
        test("pwwkew"); //answer = 3 (i.e. wke)
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0, right = 0;
        var charSet = new HashSet<Character>();

        while (right < s.length()) {
            if (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            } else {
                charSet.add(s.charAt(right));
                right++;
                result = Math.max(result, charSet.size());
            }
        }
        return result;
    }

    static void test(String s) {
        var cut = new LeetCode3_LongestSubstringWithoutRepeatingChars();

        System.out.println("Input: " + s);
        System.out.println("Result: " + cut.lengthOfLongestSubstring(s));
        System.out.println("---------------");
    }
}
