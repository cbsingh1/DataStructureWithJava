package com.cbsingh.leetcode;

public class LeetCode14_LongestCommonPrefix {
    public static void main(String[] args) {
        //String []strs ={"flower","flow","flight"};
        String []strs ={"","b"};
        //String []strs ={"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length<1) return "";
        String commonStr=strs[0];
        for(int j=1; j<strs.length; j++) {
            String currentStr="";
            for(int i=0; i<strs[j].length() && i<commonStr.length(); i++) {
                if(commonStr.charAt(i)!=strs[j].charAt(i))
                    break;
                currentStr += strs[j].charAt(i);
            }
            if(currentStr=="") return "";
            commonStr=currentStr;
        }
        return commonStr;
    }
}
