package com.cbsingh.leetcode;

public class LeetCode392_IsSubsequence {

    private static boolean checkIsSubsequence(String s, String t) {
        int tCounter=0, sCounter=0;
        while (tCounter < t.length() && sCounter < s.length()) {
            if(s.charAt(sCounter) == t.charAt(tCounter))
                sCounter++;

            tCounter++;
        }
        return sCounter == s.length();
    }

    private static boolean checkIsSubsequenceUsingJavaIndexOfMethod(String s, String t) {
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            prev = t.indexOf(s.charAt(i), prev + 1);
            if (prev == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIsSubsequence("abc", "ahbgdc"));
        System.out.println(checkIsSubsequence("axc", "ahbgdc"));
        System.out.println(checkIsSubsequence("", "ahbgdc"));
    }
}
