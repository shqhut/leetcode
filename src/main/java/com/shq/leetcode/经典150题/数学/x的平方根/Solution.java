package com.shq.leetcode.经典150题.数学.x的平方根;

public class Solution {

    // 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
    // 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
    // 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
    public int mySqrt(int x) {
        // 正整数的算术平方根一定是(1,x/2)
        if (x == 1) {
            return 1;
        }
        int left = 1, right = x/2;
        while (left < right) {
            int mid = left + (right - left)/2;
            long value =(long) mid * mid;
            if (value == x) {
                return mid;
            } else if (value < x) {
                left = mid + 1;
            } else if (value > x) {
                right = mid - 1;
            }
        }
        if ((long)left * left > x) {
            return left-1;
        }
        return left;
    }

}
