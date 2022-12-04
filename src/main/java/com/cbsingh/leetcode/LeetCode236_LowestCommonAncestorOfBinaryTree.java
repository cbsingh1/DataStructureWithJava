package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

public class LeetCode236_LowestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        left.right = new TreeNode(4);
        left.right.left = new TreeNode(6);
        left.right.right = new TreeNode(7);

        right.left=new TreeNode(5);
        right.left.right = new TreeNode(8);

        System.out.println(lowestCommonAncestor(root, left,right));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)
            return null;
        if(root==p || root==q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null & right != null)
            return root;

        return left != null ? left : right;
    }
}
