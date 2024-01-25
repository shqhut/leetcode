package com.shq.leetcode.动态规划.裴波那契数;

public class Solution {

    /**
     * 暴力递归
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    /**
     * 使用备忘录
     */
    public int fibWithMemo(int n) {
        if (n < 1) return 0;
        int[] memo = new int[n+1];
        // 带备忘录的递归
        return help(memo,n);
    }

    public int help(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = help(memo,n-1) + help(memo, n-2);
        return memo[n];
    }

    /**
     * 动态规划思路解题
     * @param n
     * @return
     */
    public int fibDp(int n) {
        // 动态规划思想做
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
