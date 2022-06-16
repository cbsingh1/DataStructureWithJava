package com.cbsingh.array.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNumOfAnagram {

    public static void main(String[] args) {
        String s = "eaylnlfdxf";
        String pattern = "irc";

        //System.out.println(countNumOfAnagramBruteForce(s, pattern));
        //System.out.println(countNumOfAnagramUsingSubstring(s, pattern));
        System.out.println(countNumOfAnagramWithSlidingWindow(s, pattern));
    }

    private static int countNumOfAnagramBruteForce(String s, String pattern) {
        int count=0;
        List<String> anagramList = new ArrayList<>();
        anagramList.addAll(List.of("baaa", "abaa", "aaba", "aaab"));

        for (int i = 0; i <s.length()-pattern.length() +1 ; i++) {
            String tempStr = "";
            for (int j = i; j < i+pattern.length(); j++)
                tempStr += String.valueOf(s.charAt(j));

            if(anagramList.contains(tempStr))
                count++;
        }
        return count;
    }

    private static int countNumOfAnagramUsingSubstring(String s, String pattern) {
        int count=0;

        List<String> anagramList = new ArrayList<>();
        anagramList.addAll(List.of("baaa", "abaa", "aaba", "aaab"));

        for (int i = 0; i <s.length()-pattern.length() +1 ; i++) {
            String temp = s.substring(i, i+pattern.length());
            if(anagramList.contains(temp))
                count++;
        }

        return count;
    }

    private static int countNumOfAnagramWithSlidingWindow(String s, String pattern) {
        int count=0, charCount, i=0, j=0;
        char currentChar;
        Map<Character, Integer> charCountMap = new HashMap<>();
        Map<Character, Integer> patternMap = new HashMap<>();
        for (int p = 0; p < pattern.length(); p++) {
            currentChar = pattern.charAt(p);

            if(patternMap.containsKey(currentChar)) {
                charCount = patternMap.get(currentChar);
                patternMap.put(currentChar, ++charCount);
            } else
                patternMap.put(currentChar, 1);
        }

        while (j<s.length()) {
            currentChar = s.charAt(j);
            if(charCountMap.containsKey(currentChar)) {
                charCount = charCountMap.get(currentChar);
                charCountMap.put(currentChar, ++charCount);
            } else
                charCountMap.put(currentChar, 1);

            if(j-i+1 == pattern.length()) {
                if(patternMap.equals(charCountMap))
                    count++;

                if(charCountMap.containsKey(s.charAt(i))) {
                    charCount = charCountMap.get(s.charAt(i));
                    if(charCount > 1)
                        charCountMap.put(s.charAt(i), --charCount);
                    else
                        charCountMap.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return count;
    }
}
