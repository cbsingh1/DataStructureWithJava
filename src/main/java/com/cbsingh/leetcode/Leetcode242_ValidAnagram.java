package com.cbsingh.leetcode;

public class Leetcode242_ValidAnagram {
    public static void main(String[] args) {
        test("anagram", "nagaram"); //answer = true
        test("rat", "car"); //answer = false
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int i : count) {
            if(i!=0) return false;
        }
        return true;
    }

    static void test(String s, String t) {
        var cut = new Leetcode242_ValidAnagram();

        System.out.println("Input: " + s + ", " + t);
        System.out.println("Result: " + cut.isAnagram(s, t));
        System.out.println("---------------");
    }
}
