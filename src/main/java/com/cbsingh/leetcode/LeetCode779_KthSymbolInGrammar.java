package com.cbsingh.leetcode;

public class LeetCode779_KthSymbolInGrammar {


    public static void main(String[] args) {

       for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= Math.pow(2, i - 1); j++) {
                System.out.print(kthGrammar(i, j) + "  ");
            }
            System.out.println();
        }

        System.out.print(kthGrammar(4, 5));
    }

    public static int kthGrammar(int n, int k) {
        int val = (int) Math.pow(2, n - 1);
        if (n == 1)
            return 0;
        if (k <= val / 2) {
            return kthGrammar(n - 1, k);
        } else {
            int result = kthGrammar(n - 1, (k - (val/2)));
            return Math.abs(result - 1);
        }
    }

}
