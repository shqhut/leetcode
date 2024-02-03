package com.shq.leetcode.labuladong.哈希表经典习题.找不同;

class Solution {

    //  给定两个字符串 s 和 t ，它们只包含小写字母。
    //  字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    //  请找出在 t 中被添加的字母。
    //  s = "abcd", t = "abcde"
    public char findTheDifference(String s, String t) {
        int[] count1 = encode(s);
        int[] count2 = encode(t);
        for (int i=0; i<count1.length; i++) {
            if (count1[i] != count2[i]) {
                return (char) (i+'a');
            }
        }
        return 'a';
    }

    int[] encode(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            count[i]++;
        }
        return count;
    }

}
