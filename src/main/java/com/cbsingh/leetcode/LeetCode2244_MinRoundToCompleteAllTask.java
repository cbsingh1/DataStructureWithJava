package com.cbsingh.leetcode;

import java.util.*;

public class LeetCode2244_MinRoundToCompleteAllTask {
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[] {2,2,3,3,2,4,4,4,4,4}));
    }

    public static int minimumRounds(int[] tasks) {
        int answer=0;
        Map<Integer, Integer> taskCountMap = new HashMap<>();
        Arrays.stream(tasks)
                .forEach(n -> taskCountMap.put(n, taskCountMap.getOrDefault(n, 0)+1));

        for(int val : taskCountMap.values()) {
            if(val==1) return -1;

            if(val%3==0)
                answer += val/3;
            else
                answer += val/3 + 1;
        }
        return answer;
    }
}
