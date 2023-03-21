package com.cbsingh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode589_NArrTreePreorderTraversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root.children.size()<1) {
            return result;
        }
        result.add(root.val);
        for(Node node : root.children) {
            preorder(node);
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

