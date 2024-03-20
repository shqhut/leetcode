package com.shq.leetcode.经典150题.二叉树.最大二叉树;

public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0, nums.length-1);
    }

    TreeNode build(int[] nums, int lo, int ln) {
        if (lo > ln) {
            return null;
        }
        int index = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = lo; i <= ln; i++) {
            if (maxValue < nums[i]) {
                index = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums,lo, index-1);
        root.right = build(nums,index+1, ln);
        return root;
    }

}

//Definition for a binary tree node.
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
