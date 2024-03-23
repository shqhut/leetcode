package com.shq.leetcode.经典150题.二叉树.二叉树展开为链表;

/**
 * 给你二叉树的根结点root，请你将它展开一个单链表
 */
public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        // 后序遍历位置
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
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

