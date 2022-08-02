package com.cbsingh.DP;

public class KnapsackProblem {
    public static void main(String[] args) {
        int []weightArr = {1,2,3};
        int []valArr = {6,10,12};
       // System.out.println(maxValRecursive(weightArr, valArr, weightArr.length, 5));
        System.out.println(maxValDP(weightArr, valArr, weightArr.length, 5));
    }

    private static int maxValRecursive(int[] weightArr, int[] valArr, int n, int w) {
        if(n==0 || w==0)
            return 0;

        if(weightArr[n-1] <= w) {
            return Math.max(valArr[n-1] + maxValRecursive(weightArr,valArr, n-1, w-weightArr[n-1]),
                    maxValRecursive(weightArr,valArr, n-1, w));
        } else {
            return maxValRecursive(weightArr, valArr, n-1, w);
        }
    }

    private static int maxValDP(int[] weightArr, int[] val, int n, int w) {
        int [][]matrix = new int[n+1][w+1];

        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if(weightArr[i-1] <= j) {
                    matrix[i][j]= Math.max(val[i-1] + matrix[i-1][j-weightArr[i-1]],
                                            matrix[i-1][j]);
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        return matrix[n][w];
    }
}
