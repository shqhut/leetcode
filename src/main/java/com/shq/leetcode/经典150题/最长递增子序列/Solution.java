package com.shq.leetcode.经典150题.最长递增子序列;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        // dp[i]存储的是：以nums[i]结尾的最长子序列长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 1;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        return ans;
    }


}
