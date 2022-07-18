package com.cbsingh.leetcode;

public class LeetCode85_MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        //char[][] matrix = {{'1'}};

        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;

        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(Character.getNumericValue(matrix[i][j])==0)
                    height[j]=0;
                else
                    height[j] += 1;
            }
            maxArea = Math.max(maxArea, calcMAH(height));
        }

        return maxArea;
    }

    private static int calcMAH(int[] arr) {
        int max = 0;
        if(arr == null || arr.length == 0)
            return 0;

        int []left = new int[arr.length];
        int []right = new int[arr.length];
        left[0]=-1;
        right[arr.length-1] = arr.length;

        for (int i = 1; i < arr.length; i++) {
            int p = i-1;
            while (p>=0 && arr[p]>=arr[i])
                p--;

            left[i]=p;
        }
        for (int i = arr.length-2; i >=0; i--) {
            int p = i+1;
            while (p<arr.length && arr[p]>=arr[i])
                p++;

            right[i]=p;
        }

        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i] * (right[i]-left[i]-1));

        return max;
    }
}
