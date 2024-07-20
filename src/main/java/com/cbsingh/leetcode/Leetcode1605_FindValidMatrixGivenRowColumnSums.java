package com.cbsingh.leetcode;

import java.util.Arrays;

public class Leetcode1605_FindValidMatrixGivenRowColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        var solution = new Leetcode1605_FindValidMatrixGivenRowColumnSums();
        int[] rowSum = { 5,7,10 };
        int[] colSum = { 8,6,8 };
        int[][] result = solution.restoreMatrix(rowSum, colSum);
        System.out.println(Arrays.deepToString(result));
    }
}
