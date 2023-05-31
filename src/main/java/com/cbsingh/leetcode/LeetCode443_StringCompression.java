package com.cbsingh.leetcode;

public class LeetCode443_StringCompression {
    public static void main(String[] args) {
       char[] chars = {'a','a','a','a','a','b'};
       //char[] chars = {'a','b','c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        if(chars.length<2) return chars.length;
        int resultLen=0, currentLen=1;
        int pointer=1;
        String s= String.valueOf(chars[0]);
        for(int i=1; i<chars.length; i++){
            if (chars[i]== chars[i-1]) {
                currentLen++;
            } else {
                //resultLen += (currentLen>1) ? Integer.toString(currentLen).length()+1 : 1;


                if(currentLen >1)   s += currentLen;
                s += chars[i];

                if(i != chars.length-1) currentLen = 1;
            }
        }
        s+= currentLen;

        System.arraycopy(s.toCharArray(),0, chars, 0, s.length());
        //resultLen += (currentLen>1) ? Integer.toString(currentLen).length():0;
        return s.length();
    }
}
