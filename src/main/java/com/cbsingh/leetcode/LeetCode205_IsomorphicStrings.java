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

    public static void main(String[] args) {
        System.out.println(checkIfStringAreIsomorphicWithMap("egg", "add"));
        System.out.println(checkIfStringAreIsomorphicWithMap("badc", "baba"));
        System.out.println(checkIfStringAreIsomorphicWithMap("foo", "bar"));
        System.out.println(checkIfStringAreIsomorphicWithMap("paper", "title"));
    }
}
