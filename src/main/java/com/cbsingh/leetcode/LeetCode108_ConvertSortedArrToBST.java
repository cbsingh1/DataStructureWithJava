package com.cbsingh.leetcode;

import com.cbsingh.tree.TreeNode;

import java.util.Arrays;

public class LeetCode108_ConvertSortedArrToBST {
    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        TreeNode result = sortedArrayToBST(nums);
        System.out.println(TreeNode.levelOrderTraversalIterative(result));
    }
    public static TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length ==1)
            return new TreeNode(nums[0]);
        if(nums.length < 1) return null;

        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        if(mid< nums.length-1)
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
        else
            root.right = null;
        return root;
    }
}
