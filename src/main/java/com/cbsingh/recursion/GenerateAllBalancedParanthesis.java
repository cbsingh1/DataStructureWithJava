package com.cbsingh.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBalancedParanthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        getStrings(list, "", 0,0, n);
        return list;
    }

    private static void getStrings(List<String> list, String str, int open, int close, int max) {
        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            getStrings(list, str+"(", open+1, close, max);
        if(close < open)
            getStrings(list, str+")", open, close+1, max);
    }
}
