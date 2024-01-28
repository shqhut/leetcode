package com.shq.leetcode.经典150题.最后一个单词的长度;

public class Solution {

    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        if (trim.length() == 0) {
            return 0;
        }
        int len = 0;
        int index = 0;
        char[] chars = trim.toCharArray();
        while (index < chars.length) {
            if (chars[index] == ' ') {
                len=0;
            }else {
                len++;
            }
            index++;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "   fly me   to   the moon  ";
        solution.lengthOfLastWord(s);
    }

}
