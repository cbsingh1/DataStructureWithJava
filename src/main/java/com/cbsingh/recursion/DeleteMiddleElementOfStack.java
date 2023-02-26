package com.cbsingh.recursion;

import java.util.Stack;

public class DeleteMiddleElementOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        System.out.println(stack);
        stack = deleteMiddleElement(stack);
        System.out.println(stack);
    }

    private static Stack<Integer> deleteMiddleElement(Stack<Integer> stack) {
        if (stack.size()==0)
            return stack;
        int middleElementIndex = stack.size()/2 + 1;
        stack = delteElementAtIndex(stack, middleElementIndex);
        return stack;
    }

    private static Stack<Integer> delteElementAtIndex(Stack<Integer> stack, int middleElementIndex) {
        if(middleElementIndex==1) {
            stack.pop();
            return stack;
        }
        int temp = stack.pop();
        stack = delteElementAtIndex(stack, middleElementIndex-1);
        stack.push(temp);
        return stack;
    }
}
