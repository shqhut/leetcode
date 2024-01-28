package com.shq.leetcode.经典150题.判断子序列;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length();
        int m = t.length();
        // 边界情况：s、t长度为0时的情况要兼容
        while (n>0 && j<m) {
            if (s.charAt(i) == t.charAt(j)) {
                if (++i == n) {
                    return true;
                }
            }
            j++;
        }
        return i == n;
    }

}
