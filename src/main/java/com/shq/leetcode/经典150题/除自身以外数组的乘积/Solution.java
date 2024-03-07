package com.shq.leetcode.经典150题.除自身以外数组的乘积;

public class Solution {

    // 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
    // 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
    // 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]*nums[i];
        }
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            suffix[i] = suffix[i+1]*nums[i];
        }
        int[] res = new int[n];
        res[0] = suffix[1];
        res[n-1] = prefix[n-2];
        for (int i = 1; i < n-1; i++) {
            res[i] = prefix[i-1] * suffix[i+1];
        }
        return res;
    }

}
