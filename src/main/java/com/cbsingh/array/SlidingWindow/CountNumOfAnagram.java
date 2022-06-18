package com.cbsingh.array.SlidingWindow;

import java.util.HashMap;


/**
 *  We would create a Map of Pattern initially.
 *  Then for each Substring, we will do changes in same hashmap.
 *  Additionally, we will maintain a indicator to identify count of chars with more than zero value.
 */
public class CountNumOfAnagram {

    private static int countNumOfAnagramWithSlidingWindow(String s, String pattern) {
        int anagramCount=0, charCount, i=0, j=0, distinctCharsInMapValueMoreThanZero=0;
        HashMap<Character, Integer> patternMap = new HashMap<>();
        for (int p = 0; p < pattern.length(); p++) {
            charCount = patternMap.getOrDefault(pattern.charAt(p), 0);
            patternMap.put(pattern.charAt(p), ++charCount);
        }
        distinctCharsInMapValueMoreThanZero = patternMap.size();

        while (j<s.length()) {
            if(patternMap.containsKey(s.charAt(j))) {
                charCount = patternMap.get(s.charAt(j));
                if(charCount==1)
                    distinctCharsInMapValueMoreThanZero--;

                patternMap.put(s.charAt(j), --charCount);
            }

            if(j-i+1 == pattern.length()) {
                if(distinctCharsInMapValueMoreThanZero == 0)
                    anagramCount++;

                if(patternMap.containsKey(s.charAt(i))) {
                    charCount = patternMap.getOrDefault(s.charAt(i),0);
                    if(charCount==0)
                        distinctCharsInMapValueMoreThanZero++;

                    patternMap.put(s.charAt(i), ++charCount);
                }
                i++;
            }
            j++;
        }
        return anagramCount;
    }

    public static void main(String[] args) {
        String s = "aabaabaa";
        String pattern = "aaba";
        System.out.println(countNumOfAnagramWithSlidingWindow(s, pattern));
    }
}
