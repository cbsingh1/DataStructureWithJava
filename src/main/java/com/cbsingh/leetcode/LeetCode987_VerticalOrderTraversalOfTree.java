package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

import java.util.*;

public class LeetCode987_VerticalOrderTraversalOfTree {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        TreeNode root = new TreeNode(4, left, right);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);

        System.out.println(verticalTraversal(root));
    }

    static TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 0, 0);
        List<List<Integer>> vertical = new ArrayList<>();
        for (int col : map.keySet()) {
            List<Integer> level = new ArrayList<>();
            for (List<Integer> list : map.get(col).values()) {
                Collections.sort(list);
                level.addAll(list);
            }
            vertical.add(level);
        }
        return vertical;
    }

    private static void helper(TreeNode root,int row, int col) {
        if(root==null)
            return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new ArrayList<>());
        map.get(col).get(row).add(root.val);

        helper(root.left,row+1, col-1);
        helper(root.right, row+1,  col+1);
    }
}
