package com.cbsingh.leetcode;

import java.util.*;

public class LeetCode692 {

    public static void main(String[] args) {
        String [] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        var list = new ArrayList<String>();
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);

        var pq = new PriorityQueue<Map.Entry<String, Integer>>((m1, m2) -> {
            if(m1.getValue()== m2.getValue())
                return m1.getKey().compareTo(m2.getKey());
            else
                return m2.getValue() - m1.getValue();
        });

        for (Map.Entry m : map.entrySet())
            pq.add(m);

        while(k-->0)
            list.add(pq.poll().getKey());

        return list;
    }
}