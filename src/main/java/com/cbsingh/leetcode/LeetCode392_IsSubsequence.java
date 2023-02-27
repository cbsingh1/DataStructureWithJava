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

    private static boolean checkIsSubsequenceUsingRecursion(String s, String t) {
        if(isSubsequenceHelper(s, t, s.length(), t.length()))
            return true;
        return false;
    }

    private static boolean isSubsequenceHelper(String s, String t, int sLength, int tLength) {
        if(sLength==0) return true;
        if(tLength==0) return false;
        if(s.charAt(sLength-1)==t.charAt(tLength-1))
            return isSubsequenceHelper(s, t, sLength-1, tLength-1);
        return isSubsequenceHelper(s, t, sLength, tLength-1);
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
        System.out.println(checkIsSubsequenceUsingRecursion("abc", "ahbgdc"));
        //System.out.println(checkIsSubsequence("axc", "ahbgdc"));
       // System.out.println(checkIsSubsequence("", "ahbgdc"));
    }
}
