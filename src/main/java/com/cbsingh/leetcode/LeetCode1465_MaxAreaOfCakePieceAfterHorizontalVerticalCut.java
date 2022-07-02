package com.cbsingh.leetcode;

import java.util.Arrays;

public class LeetCode1465_MaxAreaOfCakePieceAfterHorizontalVerticalCut {

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            if (horizontalCuts[i] - horizontalCuts[i - 1] > maxH)
                maxH = horizontalCuts[i] - horizontalCuts[i - 1];
        }
        int maxV = Math.max(verticalCuts[0] - 0, w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            if (verticalCuts[i] - verticalCuts[i - 1] > maxV)
                maxV = verticalCuts[i] - verticalCuts[i - 1];
        }
        long ans = 1L * maxH * maxV;
        return (int) (ans % 1000000007);

       /* The number taken for mod  should just be large enough to fit in the largest integer data type
       i.e it makes sure that there is no overflow in the result.
        It should be a prime number because if we take mod of a number by Prime the result is generally spaced i.e.
        the results are very different results in comparison to mod the number by non-prime, that is why primes are generally used for mod.
        10^9+7 fulfills both the criteria. It is the first 10-digit prime number and fits in int data type as well.
        In fact, any prime number less than 2^30 will be fine in order to prevent possible overflows. */
    }

    public static void main(String[] args) {
        System.out.println(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
        System.out.println(maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
        System.out.println(maxArea(5, 4, new int[]{3}, new int[]{3}));

    }
}
