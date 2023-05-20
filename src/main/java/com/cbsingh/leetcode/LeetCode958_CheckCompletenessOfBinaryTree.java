package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

import java.util.LinkedList;

public class LeetCode958_CheckCompletenessOfBinaryTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        TreeNode root = new TreeNode(1, left, right);

        System.out.println(isCompleteTreeDFS(root));
    }


    //Solution using BFS approach
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        var queue = new LinkedList<TreeNode>();
        boolean nullNodeFound = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null)
                nullNodeFound = true;
            else {
                if (nullNodeFound) return false;
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return true;
    }

    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static boolean dfs(TreeNode node, int index, int n) {
        if (node == null) return true;

        // If index assigned to current node is greater or equal to the number of nodes
        // in tree, then the given tree is not a complete binary tree.
        if (index >= n) return false;

        // Recursively move to left and right subtrees.
        return dfs(node.left, 2 * index + 1, n) &&
                dfs(node.right, 2 * index + 2, n);
    }

    public static boolean isCompleteTreeDFS(TreeNode root) {
        return dfs(root, 0, countNodes(root));
    }
}
