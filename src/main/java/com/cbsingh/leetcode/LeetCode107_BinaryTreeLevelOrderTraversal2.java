package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode107_BinaryTreeLevelOrderTraversal2 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        left.right = new TreeNode(4);
        left.right.left = new TreeNode(6);
        left.right.right = new TreeNode(7);

        right.left=new TreeNode(5);
        right.left.right = new TreeNode(8);

        System.out.println(levelOrderBottomDFS(root));
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            levelList = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode current = queue.poll();
                levelList.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                size--;
            }
            result.add(0, levelList);
        }
        return result;
    }

    public static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        dfs(resultList, root, 0);
        return resultList;
    }

    private static void dfs(List<List<Integer>> resultList, TreeNode root, int level) {
        if(root==null)
            return;

        if(level== resultList.size())
            resultList.add(level, new LinkedList<>());

        dfs(resultList, root.left, level+1);
        dfs(resultList, root.right, level+1);
        resultList.get(resultList.size()-level-1).add(root.val);
    }
}
