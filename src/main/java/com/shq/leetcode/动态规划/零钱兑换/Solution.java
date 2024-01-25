package com.shq.leetcode.动态规划.零钱兑换;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        return getCoins(coins,amount,memo);
    }

    public int getCoins(int[] coins,int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != 0) {
            return memo[amount];
        }
        // 求最小值，初始值为最大值
        int result = Integer.MAX_VALUE;
        for (int coin:coins) {
            int temp = getCoins(coins,amount-coin, memo);
            if (temp == -1) {
                // 当金额能正常兑换就跳出循环
                continue;
            }
            result = Math.min(result,temp+1);
        }
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        Solution solution = new Solution();
        int i = solution.coinChange(coins, 6);
        System.out.println(i);
    }

}
