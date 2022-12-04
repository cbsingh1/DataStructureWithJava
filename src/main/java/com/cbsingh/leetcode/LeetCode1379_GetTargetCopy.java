package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;
import com.sun.source.tree.Tree;

public class LeetCode1379_GetTargetCopy {

    public static void main(String[] args) {
        TreeNode originalRoot = new TreeNode(7);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(19);

        originalRoot.left = left;
        originalRoot.right = right;

        TreeNode cloned = originalRoot;

        TreeNode result = getTargetCopy(originalRoot, cloned, right);
        System.out.println(result);
    }

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        TreeNode current = cloned;

        if(current==null || current.val == target.val)
            return current;

        TreeNode left = getTargetCopy(original, current.left, target);
        TreeNode right = getTargetCopy(original, current.right, target);

        if(left!=null)
            return current.left;
        if(right != null)
            return current.right;

        return null;
    }

}
