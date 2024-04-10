package com.shq.leetcode.经典150题.二叉树.最大二叉树;

public class Solution3 {

    TreeNode constructMaximumBinaryTree(int[] nums) {
        // 借助外部函数，方便操作数组下标
        return build(nums, 0, nums.length-1);
    }

    // 函数定义：将nums[lo, hi] 构建成二叉树，并返回根节点
    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (hi < lo) {
            return null;
        }
        // 获取最大元素及其下标
        int index = -1,maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, lo, index-1);
        root.right = build(nums, index+1, hi);
        return root;
    }



}
