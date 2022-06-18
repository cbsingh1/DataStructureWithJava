package com.cbsingh.array.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {

    private static List<Integer> getAnagramIndex(String s, String p) {
        List<Integer> anagramIndexList = new ArrayList<>();
        int i=0, j=0, charCount, distinctCharInMapWithValueMoreThanZero;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c: p.toCharArray()) {
            charCount = charMap.getOrDefault(c, 0);
            charMap.put(c, ++charCount);
        }
        distinctCharInMapWithValueMoreThanZero = charMap.size();
        while (j < s.length()) {
            if(charMap.containsKey(s.charAt(j))) {
                charCount = charMap.get(s.charAt(j));
                if(charCount==1)
                    distinctCharInMapWithValueMoreThanZero--;

                charMap.put(s.charAt(j), --charCount);
            }

            if(j-i+1 == p.length()) {
                if(distinctCharInMapWithValueMoreThanZero == 0)
                    anagramIndexList.add(i);

                if(charMap.containsKey(s.charAt(i))) {
                    charCount = charMap.get(s.charAt(i));
                    if(charCount==0)
                        distinctCharInMapWithValueMoreThanZero++;

                    charMap.put(s.charAt(i), ++charCount);
                }
                i++;
            }
            j++;
        }
        return anagramIndexList;
    }

    public static void main(String[] args) {
        System.out.println(getAnagramIndex("cbaebabacd","abc"));
        System.out.println(getAnagramIndex("abab","ab"));
    }
}
