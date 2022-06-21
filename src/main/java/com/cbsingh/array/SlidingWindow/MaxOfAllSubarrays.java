package com.cbsingh.array.SlidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubarrays {

    private static int[] findMaxOfAllSubArrays(int[] arr, int subArraySize) {
        int[] answerArr = new int[arr.length - subArraySize + 1];
        int i = 0, j = 0, count = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (j < arr.length) {
            while (!deque.isEmpty() && deque.getLast() < arr[j])
                deque.removeLast();

            deque.add(arr[j]);
            if (j - i + 1 == subArraySize) {
                answerArr[count++] = deque.getFirst();
                if (deque.getFirst() == arr[i])
                    deque.removeFirst();
                i++;
            }
            j++;
        }
        return answerArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxOfAllSubArrays(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
    }
}
