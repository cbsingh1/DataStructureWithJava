package com.cbsingh.stack;

import java.util.EmptyStackException;

public class StackImplUsingArray {

    private int[] stack;
    private int top;

    public StackImplUsingArray(int capacity) {
        stack = new int[capacity];
    }

    public void push(int element) {

        if (top == stack.length) {
            int[] newArray = new int[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int i = stack[--top];
        stack[top] = 0;

        return i;
    }

    public int size() {
        return top;
    }

    public void print() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImplUsingArray stack = new StackImplUsingArray(2);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.print();

        System.out.println(stack.peek());

        stack.pop();
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.print();
        System.out.println(stack.pop());
        stack.push(70);
        stack.print();
    }
}
