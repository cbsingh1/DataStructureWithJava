package com.cbsingh.array;

public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        String []str = {"zbc","mab","ghy"};
        System.out.println(minDeletionSize(str));
    }
    public static int minDeletionSize(String[] strs) {
        int result=0;
        int wordLength = strs[0].length();
        for(int col=0; col < wordLength; col++) {
            for (int row = 1; row < strs.length; row++) {
                if(strs[row].charAt(col) < strs[row-1].charAt(col)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
