package com.cbsingh.leetcode;

public class LeetCode744_FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        System.out.println(new LeetCode744_FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c','f','j'}, 'j'));
/*        System.out.println(new LeetCode744_FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c','f','j'}, 'c'));
        System.out.println(new LeetCode744_FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c','f','j'}, 'd'));
        System.out.println(new LeetCode744_FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'a', 'b'}, 'z'));
        System.out.println(new LeetCode744_FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'e', 'e', 'e', 'e','e', 'e', 'n','n','n','n'}, 'e'));*/
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int start=0, end=n;
        while (start<end) {
            int mid = start+(end-start)/2;
            if(letters[mid]>target)
                end = mid;
            else
                start=mid+1;
        }
        return letters[start%n];
    }
}
