package com.cbsingh.leetcode;

import java.util.Stack;

public class LeetCode394_DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        String current="";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int count=0;
        for(Character ch:s.toCharArray()) {
            if (Character.isDigit(ch))
                count = count * 10 + ch - '0';
            else if (ch == '[') {
                countStack.push(count);
                resStack.push(current);
                current = "";
                count=0;
            }
            else if (ch == ']') {
                String temp = current;
                current=resStack.pop();
                for (count = countStack.pop(); count >= 1; count--)
                    current += temp;
            }
            else
                current += ch;
        }
        return current;
    }
}
