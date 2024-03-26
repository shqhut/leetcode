package com.shq.leetcode.经典150题.二叉树.二叉树展开为链表;

public class Solution2 {

    // 将以root的为根的树拉平成链表
    // 思路：利用函数定义，将左右子树拉平，在将左子树变为右子树，右子树接到左子树后面
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        // 后序位置，将左子树变为右子树，并将右子树接到后面
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 将左子树变成右子树
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
