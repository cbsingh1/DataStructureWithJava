package com.cbsingh.queue;

import java.util.LinkedList;

public class StringPalindromeCheckerWithQueueAndStack {

    public static void main(String[] args) {
        System.out.println(checkIfPalindrome("I did, did I?"));
    }

    private static boolean checkIfPalindrome(String s) {

        String lowerCaseStr = s.toLowerCase();
        LinkedList<Character> queue = new LinkedList<Character>();
        LinkedList<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < lowerCaseStr.length(); i++) {
            char c = lowerCaseStr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.add(c);
                stack.push(c);
            }
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                return false;
            }
        }
        return true;
    }
}
