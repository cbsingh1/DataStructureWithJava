package com.cbsingh.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreatToRight {

    //Solution 1 - Using Brute Force (Time complexity - O(n2)
    public static void nearestGreatToRightBruteForce(int[] arr) {
        int next;
        for (int i = 0; i < arr.length; i++) {
            next = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println("Nearest great for " + arr[i] + " : " + next);
        }
    }


    public static void nearestGreatToRightUsingStack(int arr[]) {

        int [] tempArr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >=0 ; i--) {

            if(stack.empty()) {
                tempArr[i] = -1;
            } else {

                if (arr[i] > stack.peek()) {
                    while (!stack.empty()) {
                        stack.pop();

                        if(arr[i] < stack.peek()) {
                            tempArr[i] = stack.peek();
                            break;
                        }
                    }
                } else {
                    tempArr[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(tempArr));
    }

    public static void main(String[] args) {
        int arr[] = {20, 35, -15, 7, 55, 1, -22};

        nearestGreatToRightBruteForce(arr);

        nearestGreatToRightUsingStack(arr);
    }
}
