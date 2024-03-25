package com.shq.leetcode.经典150题.二叉树.翻转二叉树;

public class Solution_Split {

    // 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
    public TreeNode invertTree(TreeNode root){
        if (root == null) {
            return null;
        }

        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;

        return root;

    }

}
