package com.cbsingh.recursion;

import java.util.Stack;

public class SortStackWithRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(0);
        System.out.println(stack);
        stack = sort(stack);
        System.out.println(stack);
    }

    static Stack<Integer> sort(Stack<Integer> stack) {
        if(stack.size()==1) {
            return stack;
        }
        int temp = stack.pop();
        stack = sort(stack);
        stack = insert(stack, temp);
        return stack;
    }

    private static Stack<Integer> insert(Stack<Integer> stack, int temp) {
        if(stack.size()==0 || stack.peek()<= temp) {
            stack.push(temp);
            return stack;
        }
        int temp1 = stack.pop();
        stack = insert(stack, temp);
        stack.push(temp1);
        return stack;
    }
}
