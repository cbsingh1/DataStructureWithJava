package com.cbsingh.leetcode;

import java.util.Stack;

/**
 * Leetcode - 678. Valid Parenthesis String (https://leetcode.com/problems/valid-parenthesis-string/)
 *
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.  '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 */
public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        Stack<Integer> openParanthesisStack = new Stack<Integer>();
        Stack<Integer> starStack = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                openParanthesisStack.push(i);
            else if (s.charAt(i) == '*')
                starStack.push(i);
            else if (s.charAt(i) == ')') {
                if(openParanthesisStack.isEmpty()) {
                    if(starStack.isEmpty()) {
                        return false;
                    } else {
                     starStack.pop();
                    }
                } else {
                    openParanthesisStack.pop();
                }
            }
        }

        while (! openParanthesisStack.isEmpty()) {
            if(starStack.isEmpty())
                return false;
            if (openParanthesisStack.pop() > starStack.pop())
                return false;
        }
        return true;
    }

    //Test program with 5 use cases
    public static void main(String[] args) {
        System.out.println(ValidParenthesisString.checkValidString("(*)"));
        System.out.println(ValidParenthesisString.checkValidString("(*))"));
        System.out.println(ValidParenthesisString.checkValidString(")*()"));
        System.out.println(ValidParenthesisString.checkValidString("*())"));
        System.out.println(ValidParenthesisString.checkValidString("**())"));
    }
}
