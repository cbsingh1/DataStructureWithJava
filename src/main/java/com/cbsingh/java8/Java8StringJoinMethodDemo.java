package com.cbsingh.java8;

import java.util.Arrays;
import java.util.List;

public class Java8StringJoinMethodDemo {

    public static void main(String[] args) {
        String languages = String.join("_", "Java", "HTML", "Python", "CSS", "PHP");

        System.out.println(languages);

        List<String> languageList = Arrays.asList("Java", "HTML", "Python", "CSS", "PHP");

        languages = String.join(", ", languageList);

        System.out.println(languages);
    }
}
