package com.cbsingh.string;

public class SubStringCounter {

    public static int countSubString(String str, String findStr) {
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){
            lastIndex = str.indexOf(findStr,lastIndex);
            if(lastIndex != -1){
                count ++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str= "abcdabcdabc";
        String findStr = "abc";

        //Normal solution
        System.out.println(countSubString(str, findStr));

        //Using String regex
        System.out.println(str.split(findStr, -1).length);

    }
}
