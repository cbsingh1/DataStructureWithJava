package com.cbsingh.tree;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    static List<Integer> inOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while (true) {
            while(current != null) {
                stack.add(current);
                current = current.left;
            }
            if(stack.isEmpty())
                break;

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }

    static List<Integer> preOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while (true) {
            while(current != null) {
                list.add(current.val);
                stack.add(current);
                current = current.left;
            }
            if(stack.isEmpty())
                break;

            current = stack.pop();
            current = current.right;
        }
        return list;
    }

    static List<Integer> postOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        TreeNode previous = null;

        while (true) {
            while(current != null) {
                stack.add(current);
                current = current.left;
            }
            if(stack.isEmpty()) break;
            while (current ==null && !stack.isEmpty()) {
                current = stack.peek();
                if(current.right==null || current.right == previous) {
                    list.add(current.val);
                    stack.pop();
                    previous = current;
                    current = null;
                }
                else {
                    current = current.right;
                }
            }
        }
        return list;
    }

    public static List<Integer> levelOrderTraversalIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        var list = new ArrayList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            list.add(current.val);
            if(current.left != null)   queue.add(current.left);
            if(current.right != null)  queue.add(current.right);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        left.right = new TreeNode(4);
        left.right.left = new TreeNode(6);
        left.right.right = new TreeNode(7);

        right.left=new TreeNode(5);
        right.left.right = new TreeNode(8);


       // System.out.println(preOrderTraversalIterative(root));
       // System.out.println(inOrderTraversalIterative(root));
       // System.out.println(postOrderTraversalIterative(root));
        System.out.println(levelOrderTraversalIterative(root));
    }
}
