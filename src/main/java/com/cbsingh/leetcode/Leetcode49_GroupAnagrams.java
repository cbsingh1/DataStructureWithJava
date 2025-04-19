package com.cbsingh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode49_GroupAnagrams {
    public static void main(String[] args) {
        test(new String[]{"eat","tea","tan","ate","nat","bat"});
        test(new String[]{"a"});
        test(new String[]{""});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        var anagramMap = new HashMap<String, List<String>>();
        for(String str : strs){
            String sortedWord = getSortedWord(str); // we can also use FreqArray for key
            anagramMap.putIfAbsent(sortedWord, new ArrayList<String>());
            anagramMap.get(sortedWord).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }

    public String getSortedWord(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    static void test(String[] strs) {
        var cut = new Leetcode49_GroupAnagrams();

        System.out.println("Input: " + Arrays.toString(strs));
        System.out.println("Result: " + cut.groupAnagrams(strs));
        System.out.println("---------------");
    }
}