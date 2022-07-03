package com.cbsingh.searching;

public class BinarySearch_FindElementFromSortedArr {

    static int findElementIndex(int[] sortedArr, int num) {
        int index=-1, start=0, end = sortedArr.length-1;
        if(sortedArr.length == 1){
            if(num == sortedArr[0])
                return 0;
            return index;
        }

        while (start <= end) {
            int mid = start + ((end-start)/2);
            if(sortedArr[mid] == num)
                return mid;
            else if (mid > num)
                end = mid-1;
            else
                start = mid +1;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(findElementIndex(new int[] {1,2,3,4,5,6,7,8,9,10}, 3));
    }
}
