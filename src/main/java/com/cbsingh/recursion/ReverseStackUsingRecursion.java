package com.cbsingh.recursion;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(1);
        stack.push(3);

        System.out.println(stack);
        System.out.println(stack.peek());
        stack = reverseStack(stack);
        System.out.println(stack);
        System.out.println(stack.peek());
    }

    private static Stack<Integer> reverseStack(Stack<Integer> stack) {
        if(stack.size()==1) {
            return stack;
        }
        int temp = stack.pop();
        stack = reverseStack(stack);
        stack= insertElementAtEnd(stack, temp);
        return stack;
    }

    private static Stack<Integer> insertElementAtEnd(Stack<Integer> stack, int lastElement) {
        if(stack.size()==0 || stack.peek() <= lastElement) {
            stack.push(lastElement);
            return stack;
        }
        int temp1 = stack.pop();
        stack = insertElementAtEnd(stack, lastElement);
        stack.push(temp1);
        return stack;
    }
}
