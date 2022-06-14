package com.cbsingh.array.SlidingWindow;

public class MaxSumSubArray {

    public static void main(String[] args) {

        int []arr = {2,3,5,2,9,7,1};
        int subArraySize = 3;

        System.out.println(calcMaxSumSubArrayBruteForce(arr, subArraySize));
        System.out.println(calcMaxSumSubArraySlidingWindow(arr, subArraySize));
    }

    private static int calcMaxSumSubArrayBruteForce(int[] arr, int subArraySize) {
        int maxSum = 0;
        for (int i = 0; i <=arr.length-subArraySize ; i++) {
            int currentSum = 0;
            for (int j = i; j < i+subArraySize; j++) {
                currentSum += arr[j];
            }
            if(currentSum > maxSum)
                maxSum = currentSum;
        }
        return maxSum;
    }

    private static int calcMaxSumSubArraySlidingWindow(int[] arr, int subArraySize) {
        int maxSum=Integer.MIN_VALUE, currentSum = 0, i=0, j=0;
        while (j < arr.length) {
            currentSum += arr[j];
            if((j-i+1) == subArraySize) {
                if(currentSum > maxSum)
                    maxSum = currentSum;

                currentSum -= arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
