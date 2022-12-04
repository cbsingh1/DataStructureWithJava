package com.cbsingh.recursion;

public class PrintSubsetsOfString {
    public static void main(String[] args) {
        printSubset("abc", "");
    }

    static void printSubset(String input, String output) {
        if(input.length()==0) {
            System.out.print(output);
            return;
        }
        String op1 = output;
        String op2 =  output + input.charAt(0);
        input = input.substring(1);

        printSubset(input,op1);
        printSubset(input, op2);
    }
}
