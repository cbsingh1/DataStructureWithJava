package com.cbsingh.stack;

import java.util.Stack;

public class MaxAreaOfHistogram {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};

        //System.out.println(getMaxAreaUsingBruteForce(arr));
        System.out.println(getMaxAreaUsingStack(arr));
        //System.out.println(getMaxAreaEfficientSol(arr));
    }

    public static int getMaxAreaEfficientSol(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i])
                p = lessFromLeft[p];

            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i])
                p = lessFromRight[p];

            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    private static int getMaxAreaUsingStack(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int psuedo_index_right = heights.length;

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            if (stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();

            stack.push(i);
        }

        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                right[i] = psuedo_index_right;
            else
                right[i] = stack.peek();

            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++)
            maxArea = Math.max(maxArea, heights[i] * right[i] - left[i] - 1);

        return maxArea;
    }

    private static int getMaxAreaUsingBruteForce(int[] arr) {
        int counter;
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            counter = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i])
                    break;
                counter++;
            }
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[i])
                    break;
                counter++;
            }
            if (maxArea < counter * arr[i])
                maxArea = counter * arr[i];
        }
        return maxArea;
    }
}
