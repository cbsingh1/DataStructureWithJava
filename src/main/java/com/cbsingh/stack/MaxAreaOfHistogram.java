package com.cbsingh.stack;

import java.util.Stack;

public class MaxAreaOfHistogram {

    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};
        //System.out.println(getMaxAreaUsingBruteForce(arr));
        System.out.println(getMaxAreaUsingStack(arr));
    }

    private static int getMaxAreaUsingBruteForce(int[] arr) {
        int counter;
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            counter = 1;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i])
                    break;
                counter++;
            }
            for (int k = i+1; k < arr.length; k++) {
                if(arr[k] < arr[i])
                    break;
                counter++;
            }
            if(maxArea < counter * arr[i])
                maxArea = counter * arr[i];
        }
        return maxArea;
    }

    private static int getMaxAreaUsingStack(int[] arr) {
        int maxArea=0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] width = new int[arr.length];
        int psuedo_index_right = arr.length;

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty())
                left[i] = -1;
             else
                left[i] = stack.peek();

             stack.push(i);
        }

        stack.clear();
        for (int i=arr.length-1; i >=0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty())
                right[i] = psuedo_index_right;
            else
                right[i] = stack.peek();

            stack.push(i);
        }

        for (int i = 0; i < arr.length; i++)
            width[i]= right[i] - left[i];

        int areaOfEachIndex;
        for (int i = 0; i < width.length; i++) {
            areaOfEachIndex =width[i] * arr[i];
            if (areaOfEachIndex > maxArea)
                maxArea = areaOfEachIndex;
        }

        stack.clear();
        return maxArea;
    }
}
