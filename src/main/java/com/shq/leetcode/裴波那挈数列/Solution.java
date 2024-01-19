package com.shq.leetcode.裴波那挈数列;

public class Solution {

    public int fib(int n) {
        // 动态规划思想做
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
