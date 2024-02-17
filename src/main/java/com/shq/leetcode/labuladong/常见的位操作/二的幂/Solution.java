package com.shq.leetcode.labuladong.常见的位操作.二的幂;

public class Solution {

    // 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
    // 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
    public boolean isPowerOfTwo(int n) {
        // 2的幂次方的二进制表示 一定是 只有最高位为1
        if (n < 0) {
            return Boolean.FALSE;
        }
        if ((n & (n-1)) == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
