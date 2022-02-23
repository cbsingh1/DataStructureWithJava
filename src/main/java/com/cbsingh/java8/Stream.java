package com.cbsingh.java8;

import java.util.ArrayList;
import java.util.List;

public class Stream {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("David");
        names.add("Johnson");
        names.add("Samontika");
        names.add("Brijesh");
        names.add("John");

        //Stream Map - Returns a stream consisting of the results of applying the given function to the elements of this stream
        names.stream().map(String::length).forEach(System.out::println);

        //Sorting as per natural order
      //  names.stream().sorted().forEach(System.out::println);

        //sorted(Comparator) : Sorting according to supplied comparator
        names.stream().sorted((String s1, String s2) -> s1.length() - s2.length()).forEach(System.out::println);

    }
}
