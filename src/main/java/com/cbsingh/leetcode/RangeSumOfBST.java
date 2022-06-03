package com.cbsingh.leetcode;

import java.util.Stack;

/**
 *  Solution for LeetCode 938 -> Range Sum of BST (https://leetcode.com/problems/range-sum-of-bst/)
 *
 *  Complexity Analysis
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(N)
 * For the recursive and iterative implementations, we are performing a DFS (Depth-First Search) traversal.
 * The recursive solution requires additional space to maintain the function call stack while the iterative solution requires additional space to maintain the stack.
 * In both implementations, the worst-case scenario occurs when the tree is is of chain shape, and we will reach all the way down to the leaf node.
 * In this case, the space required for the stack is O(N).
 *
 */

public class RangeSumOfBST {
    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        calculateSum(root, low, high);
        return sum;
    }

    //Recursive Implementation
    private void calculateSum(TreeNode root, int low, int high) {
        if(root != null) {
            if(low <= root.val&& root.val <= high)
                sum += root.val;
            if(low < root.val)
                calculateSum(root.left, low, high);
            if(root.val < high)
                calculateSum(root.right, low, high);
        }
    }

    //Iterative Implementation
/*    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high)
                    ans += node.val;
                if (low < node.val)
                    stack.push(node.left);
                if (node.val < high)
                    stack.push(node.right);
            }
        }
        return ans;
    }*/

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Driver program for execution
    public static void main(String[] args) {

    }
}
