package com.shq.leetcode.labuladong.哈希表经典习题.有效的字母异位词;

public class Solution {

    public boolean isAnagram(String s, String t) {
        int[] count1 = encode(s);
        int[] count2 = encode(t);
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
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
