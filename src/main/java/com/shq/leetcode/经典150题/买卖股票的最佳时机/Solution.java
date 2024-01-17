package com.shq.leetcode.经典150题.买卖股票的最佳时机;

class Solution {

    /**
     * 给定一个数组prices，它的第i个元素prices[i]表示一支给定股票第i天的价格。
     * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回0。
     **/
    public int maxProfit(int[] prices) {
        // 动态规划
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < prices.length; i++) {
            // 当i=0时，i-1为非法索引，所以进行特殊处理
            if (i-1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            // -prices[i] 说明是第一次买，之前肯定是0 理解这点非常关键
            dp[i][1] = Math.max(-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }
}
