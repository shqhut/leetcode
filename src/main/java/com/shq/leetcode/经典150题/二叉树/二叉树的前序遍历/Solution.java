package com.shq.leetcode.经典150题.二叉树.二叉树的前序遍历;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<Integer> res = new LinkedList<>();

    // 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
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
