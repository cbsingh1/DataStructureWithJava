package com.cbsingh.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryNumWithMore1InPrefix {
    public static void main(String[] args) {
        printNum(2);
    }

    static void printNum(int n) {
        List<String> list = new ArrayList<>();
        printBinaryNum(list,"1",  1,0,  n);
        System.out.println(list);
    }

    private static void printBinaryNum(List<String> list, String str, int one, int zero, int n) {
        if (one+zero == n){
            list.add(str);
            return;
        }
        if(one < n)
            printBinaryNum(list, str+"1", one+1, zero, n);
        if(zero < one)
            printBinaryNum(list, str+"0", one, zero+1, n);
    }
}
