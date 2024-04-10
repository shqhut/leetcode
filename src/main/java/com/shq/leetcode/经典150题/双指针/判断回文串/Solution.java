package com.shq.leetcode.经典150题.双指针.判断回文串;

public class Solution {

    // 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
    //
    // 字母和数字都属于字母数字字符。
    //
    // 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        int low = 0, high = sb.length()-1;
        while (low < high) {
            if (sb.charAt(low) != sb.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

}
