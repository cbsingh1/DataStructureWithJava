package com.cbsingh.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Leetcode2192_AllAncestorsOfNodeInDAG {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] adjacencyList = IntStream.range(0, n)
                .mapToObj(i -> new ArrayList<Integer>())
                .toArray(ArrayList[]::new);

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            var ancestors = new ArrayList<Integer>();
            var visited = new HashSet<Integer>();
            findChildren(i, adjacencyList, visited);
            for(int node : visited){
                if(node == i) continue;
                ancestors.add(node);
            }
            Collections.sort(ancestors);
            result.add(ancestors);
        }
        return result;
    }

    // Helper method to perform DFS and find all children of a given node
    private void findChildren(int currentNode, List<Integer>[] adjacencyList,
                              Set<Integer> visitedNodes) {
        visitedNodes.add(currentNode);
        for (int neighbor : adjacencyList[currentNode]) {
            // Recursively traverse all neighbors
            if(!visitedNodes.contains(neighbor))
                findChildren(neighbor, adjacencyList, visitedNodes);
        }
    }

    public static void main(String[] args) {
        var solution = new Leetcode2192_AllAncestorsOfNodeInDAG();
        int[][] edges = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        List<List<Integer>> ancestors = solution.getAncestors(8, edges);
        System.out.println(ancestors);
    }
}
