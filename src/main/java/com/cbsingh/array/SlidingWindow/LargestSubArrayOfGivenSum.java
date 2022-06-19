package com.cbsingh.array.SlidingWindow;

public class LargestSubArrayOfGivenSum {

    private static int sizeOfLargestSubArrayWithGivenSum(int[] arr, int sum) {
        int i = 0, j = 0, sizeOfLargestSubArray = 0, currentSum = 0;

        while (j < arr.length) {
            currentSum += arr[j];

            if (currentSum == sum) {
                if (sizeOfLargestSubArray < j - i + 1)
                    sizeOfLargestSubArray = j - i + 1;

                currentSum -= arr[i];
                i++;
            } else if(currentSum > sum) {
                while (currentSum > sum && i <= j) {

                    currentSum -= arr[i];
                    i++;
                    if (currentSum == sum) {
                        if (sizeOfLargestSubArray < j - i + 1)
                            sizeOfLargestSubArray = j - i + 1;
                    }
                }
            }

            j++;
        }

        return sizeOfLargestSubArray;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,1,1,2,5};
        int sum = 5;
        System.out.println(sizeOfLargestSubArrayWithGivenSum(arr, sum));
    }
}
