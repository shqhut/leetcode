package com.shq.leetcode.labuladong.字符串匹配算法.找出字符串中第一个匹配项的下标;

public class Solution {

    // 给你两个字符串 haystack 和 needle ，
    // 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
    // 如果 needle 不是 haystack 的一部分，则返回  -1 。
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        if (haystack.length() < l) {
            return -1;
        }
        for (int i = 0; i+l <= haystack.length(); i++) {
            if (haystack.substring(i,i+l).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
