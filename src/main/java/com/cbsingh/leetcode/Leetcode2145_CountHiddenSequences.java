package com.cbsingh.leetcode;
public class Leetcode2145_CountHiddenSequences {
    public static void main(String[] args) {
        test(new int[]{1,-3,4}, 1, 6); //answer = 2 ([3, 4, 1, 5] & [4, 5, 2, 6])
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int prefixSum = 0, max=0, min=0;

        for(int diff: differences){
            prefixSum += diff;
            max = Math.max(max, prefixSum);
            min = Math.min(min, prefixSum);

            if(max-min > upper-lower){ //early return
                return 0;
            }
        }

        return (upper-lower) - (max-min) + 1;
    }

    static void test(int[] differences, int lower, int upper) {
        var cut = new Leetcode2145_CountHiddenSequences();

        System.out.println("Result: " + cut.numberOfArrays(differences, lower, upper));
        System.out.println("---------------");
    }
}