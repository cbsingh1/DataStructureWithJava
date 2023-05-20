package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

import java.util.Stack;

public class LeetCode101_SymmetricTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        //left.left = new TreeNode(3);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        //right.left = new TreeNode(4);
        right.right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);

        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

    public static boolean isSymmetricRecursive(TreeNode root) {
        return root == null || isSymmetricRecursiveHelper(root.left, root.right);
    }

    private static boolean isSymmetricRecursiveHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricRecursiveHelper(left.left, right.right) && isSymmetricRecursiveHelper(left.right, right.left);
    }
}
