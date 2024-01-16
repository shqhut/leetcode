package com.shq.leetcode.经典150题.买卖股票的最佳时机;

class Solution {

    /**
     * 给定一个数组prices，它的第i个元素prices[i]表示一支给定股票第i天的价格。
     * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回0。
     **/
    public int maxProfit(int[] prices) {
        // 差值最大的两个数 [7,1,5,3,6,4]
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = prices.length-i; j > 0; j--) {
                int temp = prices[prices.length-i] - prices[j-1];
                profit = Math.max(temp, profit);
            }
        }
        return profit;
    }
}
