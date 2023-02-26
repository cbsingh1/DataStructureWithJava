package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

public class LeetCode226_InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        TreeNode root = new TreeNode(4, left, right);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);


        System.out.println(TreeNode.levelOrderTraversalIterative(root));
        TreeNode inverseTree = invertTree(root);
        System.out.println(TreeNode.levelOrderTraversalIterative(inverseTree));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
