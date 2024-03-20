package com.shq.leetcode.经典150题.二叉树.对称二叉树;

import java.util.Objects;

public class Solution {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return sig(root.left, root.right);
    }

    boolean sig(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return sig(left.left, right.right) && sig(left.right, right.left);
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

