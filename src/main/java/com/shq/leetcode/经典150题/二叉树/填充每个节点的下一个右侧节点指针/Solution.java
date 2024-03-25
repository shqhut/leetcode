package com.shq.leetcode.经典150题.二叉树.填充每个节点的下一个右侧节点指针;

public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node left, Node right) {
        if (left == null && right == null) {
            return;
        }
        // 连接相同父结点的两个子节点
        left.next = right;
        // 连接left子结点
        traverse(left.left, left.right);
        traverse(right.left, right.right);
        // 连接不同父节点相邻子结点
        traverse(left.right, right.left);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}