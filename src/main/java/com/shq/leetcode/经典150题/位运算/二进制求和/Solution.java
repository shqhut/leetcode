package com.shq.leetcode.经典150题.位运算.二进制求和;

class Solution {

    // 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
    // 输入:a = "11", b = "1"
    // 输出："100"
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int m = a.length(), n = b.length();
        // 记录进位
        int carry = 0;
        int i = 0;
        while (i<Math.max(m,n) || carry > 0) {
            int val = carry;
            val += i < m ? a.charAt(i) - '0' : 0;
            val += i < n ? b.charAt(i) - '0' : 0;
            carry = val/2;
            sb.append(val%2);
            i++;
        }
        return sb.reverse().toString();
    }
}