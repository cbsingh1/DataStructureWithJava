package com.cbsingh.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreatToLeft {
    public static void main(String[] args) {
        int arr[] = {20, 35, -15, 7, 55, 1, -22};

        // nearestGreatToLeftBruteForce(arr);
        nearestGreatToLeftUsingStack(arr);
    }

    private static void nearestGreatToLeftUsingStack(int[] arr) {

        Stack<Integer> stack = new Stack();

        int[] tempArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            if (stack.isEmpty()) {
                tempArr[i] = -1;
            } else if (stack.peek() > arr[i]) {
                tempArr[i] = stack.peek();
            } else {
                while (!stack.empty() && stack.peek() < arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    tempArr[i] = -1;
                } else {
                    tempArr[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(tempArr));
    }

    private static void nearestGreatToLeftBruteForce(int[] arr) {

        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            for (int j = i - 1; j >= 0; j--) {

                if (arr[j] > arr[i]) {
                    temp[i] = arr[j];
                    break;
                }
            }
            //temp[i] = -1;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
    }
}
