package com.shq.leetcode.经典150题.数学.回文数;

public class Solution {

    // 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    // 回文数
    // 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        // 8241 相当于 num = num*10 + nums[i];
        int temp = x;
        int y = 0;
        while (temp > 0) {
            // 获取最低位
            int i = temp % 10;
            temp = temp / 10;
            y = y*10 + i;
        }
        return x == y;
    }

}
