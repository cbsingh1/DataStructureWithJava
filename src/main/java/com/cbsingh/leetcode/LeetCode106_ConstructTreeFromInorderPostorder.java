package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode106_ConstructTreeFromInorderPostorder {

    static Map<Integer, Integer> inorderMap;
    static int postIndex;
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postIndex=postorder.length-1;
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return helper(postorder, 0, inorder.length-1);

    }

    private static TreeNode helper(int[] postorder, int inStart, int inEnd) {
        if(inStart > inEnd)
            return null;

        int index = inorderMap.get(postorder[postIndex]);
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;

        root.right = helper(postorder, index+1, inEnd);
        root.left = helper(postorder, inStart, index-1);

        return root;
    }
}
