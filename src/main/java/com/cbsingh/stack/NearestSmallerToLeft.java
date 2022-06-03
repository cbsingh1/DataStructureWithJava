package com.cbsingh.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToLeft {

    static void nearestSmalltoLeftUsingBruteForce(int[] arr) {
        int []tempArr = new int[arr.length];

        //Here i is started with index 0, to fill first element with -1.
        // If -1 is not needed, then i can be started from index 1.
        for (int i = 0; i < arr.length ; i++) {
            tempArr[i] = -1;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    tempArr[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(tempArr));
    }

    private static void nearestSmalltoLeftUsingStack(int[] arr) {
        int []tempArr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        //Here i is started with index 0, to fill first element with -1.
        // If -1 is not needed, then i can be started from index 1.
        for (int i = 0; i < arr.length ; i++) {
            tempArr[i] = -1;

            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                tempArr[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(tempArr));
    }

    public static void main(String[] args) {
        int [] arr = {4,5,2,10,8, 1, 3};

        //nearestSmalltoLeftUsingBruteForce(arr);
        nearestSmalltoLeftUsingStack(arr);
    }
}
