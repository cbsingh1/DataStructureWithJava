package com.cbsingh.leetcode;

/*A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.

        Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.

        Example 1:
        Input: n = "32"
        Output: 3
        Explanation: 10 + 11 + 11 = 32

        Example 2:
        Input: n = "82734"
        Output: 9

        Example 3:
        Input: n = "27346209830709182346"
        Output: 9*/

public class LeetCode1689_PartitionToMinNumDeciBinaryNum {

    public static int minPartitions(String n) {
        int minPartition=0;
        for (int i = 0; i < n.length(); i++) {
            if(Character.getNumericValue(n.charAt(i)) > minPartition)
                minPartition=Character.getNumericValue(n.charAt(i));
        }
        return minPartition;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }
}
