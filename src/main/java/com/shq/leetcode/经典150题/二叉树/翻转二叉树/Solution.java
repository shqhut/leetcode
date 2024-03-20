package com.shq.leetcode.经典150题.二叉树.翻转二叉树;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        traversal(root);
        return root;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        traversal(root.left);
        traversal(root.right);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

