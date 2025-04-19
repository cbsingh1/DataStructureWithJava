package com.cbsingh.leetcode;

public class LeetCode5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        test("babad"); //answer = "bab" or "aba"
        test("cbbd"); //answer = "bb"
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String longest = "";

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandAroundCenter(s, i, i);
            String even = expandAroundCenter(s, i, i + 1); // For cases like "cbbd"
            if (odd.length() > longest.length()) {
                longest = odd;
            }
            if (even.length() > longest.length()) {
                longest = even;
            }
        }
        return longest;
    }

    public String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // Here we are returning left + 1 as we updated left-- and right++ on line 27, and the next set of characters are not matching
    }

    static void test(String s) {
        var solution = new LeetCode5_LongestPalindromicSubstring();

        System.out.println("Input: " + s);
        System.out.println("Result: " + solution.longestPalindrome(s));
        System.out.println("---------------");
    }
}
