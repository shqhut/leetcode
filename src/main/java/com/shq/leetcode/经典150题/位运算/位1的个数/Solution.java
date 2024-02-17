package com.shq.leetcode.经典150题.位运算.位1的个数;

public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n&(n-1);
            res++;
        }
        return res;
    }
}
