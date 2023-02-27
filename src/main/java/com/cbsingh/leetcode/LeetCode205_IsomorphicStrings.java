package com.cbsingh.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode205_IsomorphicStrings {

    private static boolean checkIfStringAreIsomorphicWithMap(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>(), mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if((mapS.containsKey(s.charAt(i)) && mapS.get(s.charAt(i)) != t.charAt(i)) ||
                    (mapT.containsKey(t.charAt(i)) && mapT.get(t.charAt(i)) != s.charAt(i)))
                return false;

            mapS.put(s.charAt(i), t.charAt(i));
            mapT.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }

    private static boolean checkIfStringAreIsomorphicWithMap2(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);

            if (indexS != indexT) {
                return false;
            }

            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }

        return true;
    }

    private static boolean checkIfStringAreIsomorphicWithMap3(String s, String t){
        int[] m1 = new int[256], m2 = new int[256];

        for (int i = 0; i < 256; i++)
            m1[i] = m2[i] = -1;


        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;

            m1[s.charAt(i)] = m2[t.charAt(i)] = i ;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfStringAreIsomorphicWithMap3("egg", "add"));
        //System.out.println(checkIfStringAreIsomorphicWithMap("badc", "baba"));
        //System.out.println(checkIfStringAreIsomorphicWithMap("foo", "bar"));
        //System.out.println(checkIfStringAreIsomorphicWithMap("paper", "title"));
    }
}
