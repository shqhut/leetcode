package com.shq.leetcode.经典150题.滑动窗口.长度最小的子数组;

class Solution {

    // 给定一个含有n个正整数的数组和一个正整数 target 。
    // 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
    // 如果不存在符合条件的子数组，返回 0 。
    // 输入：target = 7, nums = [2,3,1,2,4,3]
    // 输出：2
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        // 创建窗口
        int winSum = 0;
        int n = nums.length;
        int left = 0, right = 0;
        while (right<n) {
            int i = nums[right];
            winSum += i;
            right++;
            // 缩小窗口
            while (left < right && winSum >= target) {
                // 将要移除的元素
                int j = nums[left];
                // 判断最优解
                int temp = right - left;
                res = Math.min(temp, res);
                // 更新窗口结果
                winSum -= j;
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        Solution solution = new Solution();
        solution.minSubArrayLen(target, nums);
    }

}