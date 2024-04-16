package com.shq.leetcode.经典150题.二叉树.路径总和;

public class Solution {

    Boolean res = Boolean.FALSE;

    int sum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        traverse(root, targetSum);
        return res;
    }

    void traverse(TreeNode root, int targetSum) {
        // base case
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left== null && root.right ==null) {
            if (sum == targetSum) {
                res = Boolean.TRUE;
            }
        }
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        sum -= root.val;
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
