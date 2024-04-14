package com.shq.leetcode.经典150题.二叉树.二叉树展开为链表;

public class Solution3 {

    // 明确函数定义：输入节点root，然后root为根的二叉树就会被拉平为一条链表。
    // 对于一个节点x，可以执行以下流程：
    //  1、先利用flatten(x.left)和flatten(x.right)将x的左右子树拉平；
    //  2、将x的右子树接到左子树下方，然后将整个左子树作为右子树；
    void flatten(TreeNode root){
        // base case
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        // 将左子树变成右子树，并将右子树接到后面
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        // 定义一个指针 操作root
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
