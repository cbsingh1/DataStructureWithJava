package com.cbsingh.searching;

public class findFirstOccurenceOfElement {

    static int findFirstOccurenceOfElement(int[] sortedArr, int num) {
        int index = -1;
        if(sortedArr.length == 1) {
            if(sortedArr[0]==num)
                return 0;
            return index;
        }
        int start=0, end = sortedArr.length-1;
        while (start<=end) {
            int mid = start + (end-start)/2;
            if(sortedArr[mid]==num) {
                index = mid;
                end = mid-1;
            } else if(sortedArr[mid] > num)
                end = mid-1;
            else
                start = mid+1;
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(findFirstOccurenceOfElement(new int[]{0,1,2,3,4,4,4,5,6}, 4));
    }
}
