package com.shq.leetcode.经典150题.位运算.数字范围按位与;

public class Solution {

    // 给你两个整数 left 和 right ，表示区间 [left, right] ，
    // 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

}
