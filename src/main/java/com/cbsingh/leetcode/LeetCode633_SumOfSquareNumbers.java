package com.cbsingh.leetcode;

public class LeetCode633_SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for(int a=0; a*a<=c; a++){
            double b = Math.sqrt(c-a*a);
            if(b == (int)b){
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum_BinarySearch(int c) {
        for(long a=0; a*a<=c; a++){
            long b = c - (int) a*a;
            if(binarySearch(0, b, b)){
                return true;
            }
        }
        return false;
    }

    boolean binarySearch(long start, long end, long target){
        if(start > end)
            return false;
        long mid = start + (end-start)/2;
        if(mid*mid == target)
            return true;
        if(mid*mid > target)
            return binarySearch(start, mid-1, target);
        return binarySearch(mid+1, end, target);
    }

    public static void main(String[] args) {
        var solution = new LeetCode633_SumOfSquareNumbers();
        var result = solution.judgeSquareSum(25);
        System.out.println(result);
        assert result;
    }
}
