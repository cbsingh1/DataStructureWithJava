package com.cbsingh.leetcode;

public class LeetCode509_FibonacciNumber {

    public static int fibRecusrion(int n) {
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        int prev = 0, cur = 1, next;
        for (int i = 2; i <= n; i++) {
            next = prev + cur;
            prev = cur;
            cur = next;
        }
        return cur;
    }


    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
    }
}
