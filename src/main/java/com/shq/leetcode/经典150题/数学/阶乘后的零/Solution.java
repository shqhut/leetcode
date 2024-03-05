package com.shq.leetcode.经典150题.数学.阶乘后的零;

public class Solution {

    // 给定一个整数 n ，返回 n! 结果中尾随零的数量。
    // 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
    public int trailingZeroes(int n) {
        // 阶乘求结尾0的数量，可转化位n的因子中右多个5，因为只有5*2=10，才会出现0
        int res = 0;
        int divisor = 5;
        while (divisor <= n) {
            res = n / divisor;
            divisor*=5;
        }
        return res;
    }

}
