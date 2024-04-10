package com.shq.leetcode.经典150题.二叉树.最大二叉树;

public class Solution2 {

    /* 主函数 */
    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // 定义：将nums[lo,hi]构造成符合条件的树，返回其根节点
    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (hi < lo) {
            return null;
        }
        // 找到nums[lo,hi]中最大值，及其下标
        int index = -1, maxVal = Integer.MIN_VALUE;
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
