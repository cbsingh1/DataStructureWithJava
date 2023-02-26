package com.cbsingh.leetcode;

public class LeetCode97_InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int i =0;
        while (i<s3.length() && s1.length() > 0 && s2.length() > 0) {

            if(s1.length()>0 && s3.charAt(i)==s1.charAt(0))
                s1= s1.length() > 1 ? s1.substring(1) : "";
            else if (s2.length()>0 && s3.charAt(i)==s2.charAt(0))
                s2= s2.length() > 1 ? s2.substring(1) : "";

            i++;
        }

        return (s1.length()==0 && s2.length()==0);
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
