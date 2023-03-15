package com.cbsingh.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrRecursion {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList(Arrays.asList(3,2,1,4,5,6,7));
        arr = sort(arr);
        System.out.println(arr);
    }

    private static ArrayList sort(ArrayList nums) {
        if(nums.size()==1) return nums;

        int temp = (int) nums.remove(nums.size()-1);
        nums = sort(nums);
        nums = insert(nums, temp);
        return nums;
    }

    private static ArrayList insert(ArrayList nums, int temp) {
        if(nums.size()==0 || (int)nums.get(nums.size()-1) <= temp) {
            nums.add(temp);
            return nums;
        }
        int lastBigNum = (int) nums.remove(nums.size()-1);
        nums = insert(nums, temp);
        nums.add(lastBigNum);
        return nums;
    }
}
