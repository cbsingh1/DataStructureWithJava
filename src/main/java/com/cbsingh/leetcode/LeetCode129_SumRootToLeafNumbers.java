package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

import java.util.Stack;

public class LeetCode129_SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);

        System.out.println(sumNumbersIterativePostOrder(root));
    }


    /**
     * Recursive DFS Solution
     * <p>
     * Time Complexity: O(N). Each node is visited once.
     * <p>
     * Space Complexity: O(H). Stack space.
     * In case of balanced tree (best case) it will be O(log N) and in case of Skewed Tree (worst case) it will be O(N)
     * <p>
     * N = Total number of nodes in the tree. H = Height of the tree.
     */
    public static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    public static int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null)
            return 0;
        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null)
            return currentSum;

        return sumNumbersHelper(node.left, currentSum) + sumNumbersHelper(node.right, currentSum);
    }

    /**
     * Iterative Post-Order Traversal
     * <p>
     * Time Complexity: O(N). Each node is visited once.
     * <p>
     * Space Complexity: O(H). Stack space.
     * In case of balanced tree (best case) it will be O(log N) and in case of Skewed Tree (worst case) it will be O(N)
     * <p>
     * N = Total number of nodes in the tree. H = Height of the tree.
     */
    public static int sumNumbersIterativePostOrder(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int curVal = 0;
        int sum = 0;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                curVal = curVal * 10 + cur.val;
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }

            if (cur.right == null && cur.left == null)
                sum += curVal;

            pre = stack.pop();
            curVal /= 10;
            cur = null;
        }
        return sum;
    }
}
