package com.shq.leetcode.经典150题.位运算.颠倒二进制位;

public class Solution2 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n >> i & 1) << (31 - i);
        }
        return res;
    }

}
