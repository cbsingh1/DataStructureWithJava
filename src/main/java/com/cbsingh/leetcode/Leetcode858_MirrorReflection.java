package com.cbsingh.leetcode;

public class Leetcode858_MirrorReflection {
    public static void main(String[] args) {
        test(2,1);
    }

    public int mirrorReflection(int p, int q) {
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

    static void test(int p, int q) {
        var cut = new Leetcode858_MirrorReflection();

        System.out.println("Input: " + p +", " + q);
        System.out.println("Result: " + cut.mirrorReflection(p,q));
        System.out.println("---------------");
    }
}
