package com.cbsingh.java11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java11PredicateNotDemo {

    public static void main(String[] args) {

        List<String> listOfString = Arrays.asList(" ", "\t", "\n", "One", "Two", "Three");

        //Before Java 11
        List<String> nonBlankString = listOfString.stream().filter(str -> ! str.isBlank()).collect(Collectors.toList());

        //After Java11
        List<String> nonBlankStringJava11 = listOfString.stream().filter(Predicate.not(String::isBlank)).collect(Collectors.toList());

        System.out.println(nonBlankStringJava11);
    }
}
