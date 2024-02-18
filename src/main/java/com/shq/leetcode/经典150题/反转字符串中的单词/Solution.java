package com.shq.leetcode.经典150题.反转字符串中的单词;

public class Solution {

    // 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
    // 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    // 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
    // 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
    // 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
    // 思路：先将整个字符串反转，然后将每个单词反转
    public String reverseWords(String s) {
        // 先将整个字符串反转，去掉前后空格
        StringBuilder stringBuilder = new StringBuilder(s.trim()).reverse();
        s = stringBuilder.toString().trim();
        String[] strs = s.split(" +");
        StringBuilder res = new StringBuilder();
        for (String str:strs) {
            if (res.length() != 0) {
                res.append(" ");
            }
            // 去除每个单词的所有前后空格
            res.append(new StringBuilder(str.trim()).reverse());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        s.trim();
        System.out.println(s);
    }

}
