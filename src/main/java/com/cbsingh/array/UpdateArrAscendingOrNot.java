package com.cbsingh.array;

public class UpdateArrAscendingOrNot {

    public static void main(String[] args) {
       //System.out.println(solution(new int[] {1, 4, 5, 6, 3}));
       System.out.println(solution(new int[] {1, 3, 5, 6, 4, 2}));
        //System.out.println(solution(new int[] {-52, 2, 31, 56, 47, 29, -35}));
    }

    static boolean solution(int[] a) {
        int i=0, j=a.length-1, k=0, prev=Integer.MIN_VALUE;
        int []result = new int[j+1];
        while(i<j) {
            if(prev<a[i]) {
                prev=a[i];
                result[k++] = a[i];
            }
            else
                return false;

            if(prev < a[j]) {
                result[k++] = a[j];
                prev = a[j];
            }
            else
                return false;

            i++;
            j--;
        }

        if(i==j)  return prev < a[i];
        else
            return true;
    }
}
