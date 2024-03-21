package com.shq.leetcode.经典150题.二叉树.二叉树的直径;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class Solution2 {

    int res = 0;

    // 外部变量记录递归到每个节点是的最大直径
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 计算直径等价于求某个结点左子树最大深度+右子树最大深度+1
        // 在后序位置计算最大直径，并更新结果
        maxDepth(root);
        return res;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 计算最深度
        maxDiameter = leftDepth + rightDepth;
        res = Math.max(maxDiameter,res);
        return 1 + Math.max(leftDepth,rightDepth);
    }

}


