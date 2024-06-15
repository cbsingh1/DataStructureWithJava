package com.cbsingh.leetcode;

import java.util.*;

public class LeetCode502_IPO {

    //O(NlgN) - uses 2 priority queues
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        var pqCapital = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        var pqProfit = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < profits.length; i++) {
            pqCapital.add(new int[]{capital[i], profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while(!pqCapital.isEmpty() && pqCapital.peek()[0] <= w) {
                pqProfit.add(pqCapital.poll());
            }
            if(pqProfit.isEmpty()) break;

            w += pqProfit.poll()[1];
        }
        return w;
    }

    //Fails with timeLimit exception
    public int findMaximizedCapital_BruteForce(int k, int w, int[] profits, int[] capital) {
        Set<Integer> usedIndexSet = new HashSet<>();
        while (k > 0) {
            int selectedIndex = -1;
            for (int i = 0; i < capital.length; i++) {
                if (!(usedIndexSet.contains(i)) && w >= capital[i]
                        && (selectedIndex == -1 || profits[i] > profits[selectedIndex])) {
                    selectedIndex = i;
                }
            }
            if (selectedIndex != -1) {
                w += profits[selectedIndex];
                usedIndexSet.add(selectedIndex);
            }
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        var solution = new LeetCode502_IPO();

        //Test case1 k=2, w=0, profits={1,2,3}, capital={0,1,1}, should return 4
        var result = solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        assert Objects.equals(4, result);
    }
}
