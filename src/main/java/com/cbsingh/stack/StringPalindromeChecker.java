package com.cbsingh.stack;

import java.util.LinkedList;

public class StringPalindromeChecker {

    private static boolean checkIfPalindrome(String str) {

        String strLowerCase = str.toLowerCase();

        for (int i = 0, j = strLowerCase.length() - 1; i < j; i++, j--) {


            while (isSpecialChar(strLowerCase.charAt(i))) {
                i++;
            }
            while (isSpecialChar(strLowerCase.charAt(j))) {
                j--;
            }

            if (i < j && strLowerCase.charAt(i) != strLowerCase.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSpecialChar(char charAt) {
        if (charAt < 'a' || charAt > 'z')
            return true;

        return false;
    }

    private static boolean checkPalindromeUsingStack(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder strBuilder = new StringBuilder(s.length());
        String lowerCase = s.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            if (lowerCase.charAt(i) >= 'a' && lowerCase.charAt(i) <= 'z') {
                strBuilder.append(lowerCase.charAt(i));
                stack.push(lowerCase.charAt(i));
            }
        }

        StringBuilder reversedStr = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedStr.append(stack.pop());
        }
        return reversedStr.toString().equals(strBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(checkIfPalindrome("I did, did I?"));
        System.out.println(checkPalindromeUsingStack("I did, did I?"));
    }
}
