package com.cbsingh.leetcode;

import java.util.Stack;

public class Java858_MirrorReflection {
    public static void main(String[] args) {

        System.out.println(mirrorReflection(2,1));
        String s = "ABC";
        Stack<Character> stack = new Stack<>();

    }

    public static int mirrorReflection(int p, int q) {
        int ext = q, reflection = p;
        while(ext % 2 == 0 && reflection % 2 == 0){
            ext /= 2;
            reflection /= 2;
        }
        if (ext % 2 == 0 && reflection % 2 == 1) return 0;
        if (ext % 2 == 1 && reflection % 2 == 1) return 1;
        if (ext % 2 == 1 && reflection % 2 == 0) return 2;
        return -1;
    }
}
