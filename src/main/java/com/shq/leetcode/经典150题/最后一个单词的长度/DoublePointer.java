package com.shq.leetcode.经典150题.最后一个单词的长度;

public class DoublePointer {

    /**
     * 双指针解法
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        // "   fly me   to   the moon  "
        // 从数组结尾开始便利，当找到最后一个单词长度的尾字符时记录坐标位置right，然后接着往前便利（通过缩小坐标）；
        // 直到找到最后一个单词的第一个字符的坐标位置的后一位left，即往前便利遇到的第一个空字符
        // right-left几位最后一个单词的长度
        char[] chars = s.toCharArray();
        int n = chars.length;
        int right = n-1;
        while (chars[right] == ' ') --right;
        int left = right;
        while (left>=0 && chars[left] != ' ') --left;
        return right-left;
    }

}
