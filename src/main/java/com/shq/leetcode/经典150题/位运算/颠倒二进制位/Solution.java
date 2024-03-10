package com.shq.leetcode.经典150题.位运算.颠倒二进制位;

public class Solution {

    // 颠倒给定的 32 位无符号整数的二进制位。
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

}
