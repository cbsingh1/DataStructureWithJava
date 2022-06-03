package com.cbsingh.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRight {

    public static void main(String[] args) {
        int []arr = {4,5,2,10,8,9,7};

        //findUsingBruteForce(arr);
        findUsingStack(arr);
    }

    private static void findUsingStack(int[] arr) {
        int []tempArr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        //Here, we are starting with last index,
        // just to fill last element with -1, if not needed, then we can start with arr.length -2
        for (int i = arr.length-1; i>=0; i--) {
            tempArr[i] = -1;
            while(!stack.isEmpty() && stack.peek() > arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) {
                tempArr[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(tempArr));
    }

    private static void findUsingBruteForce(int[] arr) {

        int []tempArr = new int[arr.length];

        for (int i = 0; i < arr.length ; i++) {
            tempArr[i] = -1;

            for (int j = i+1; j < arr.length ; j++) {

                if(arr[j] < arr[i]) {
                    tempArr[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(tempArr));
    }
}
