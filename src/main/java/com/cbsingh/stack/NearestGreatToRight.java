package com.cbsingh.stack;

public class NearestGreatToRight {

    //Solution 1 - Using Brute Force (Time complexity - O(n2)
    public static void nearestGreatToRightBruteForce(int[] arr) {
        int next;
        for (int i = 0; i < arr.length; i++) {
            next = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println("Nearest great for " + arr[i] + " : " + next);
        }
    }

    public static void main(String[] args) {
        int arr[] = {20, 35, -15, 7, 55, 1, -22};
        nearestGreatToRightBruteForce(arr);
    }
}
