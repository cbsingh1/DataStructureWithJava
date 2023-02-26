package com.cbsingh.leetcode;

public class LeetCode115_DistinctSubsequences {

    public static void main(String[] args) {
        //System.out.println(numDistinct("aab", "ab"));
        System.out.println(numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
    }

    public static int numDistinct(String s, String t) {
        if(t.length() > s.length())
            return 0;
        return getSubsequence(s, "", t);
    }

    private static int getSubsequence(String ip, String op, String target) {
        if(ip.length()==0){
            if(op.equalsIgnoreCase(target))
                return 1;
            return 0;
        }
        String op1 = op + ip.charAt(0);
        ip=ip.substring(1);
        int result0=  getSubsequence(ip, op, target);
        int result1=getSubsequence(ip, op1, target);
        return result0 + result1;
    }
}
