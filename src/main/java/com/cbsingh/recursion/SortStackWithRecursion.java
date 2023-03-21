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
        sort(stack);
        System.out.println(stack);
    }

    static void sort(Stack<Integer> stack) {
        if(stack.size()==1) {
            return;
        }
        int temp = stack.pop();
        sort(stack);
        insertLastElement(stack, temp);
    }

    private static void insertLastElement(Stack<Integer> stack, int temp) {
        if(stack.size()==0 || stack.peek()<= temp) {
            stack.push(temp);
            return;
        }
        int temp1 = stack.pop();
        insertLastElement(stack, temp);
        stack.push(temp1);
    }
}
