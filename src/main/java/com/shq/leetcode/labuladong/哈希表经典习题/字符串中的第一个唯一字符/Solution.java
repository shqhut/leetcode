package com.shq.leetcode.labuladong.哈希表经典习题.字符串中的第一个唯一字符;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        Map<Character,Integer> charToCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charToCount.put(c, charToCount.getOrDefault(c, 0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (charToCount.get(s.charAt(i)).equals(1)) {
                return i;
            }
        }
        return -1;
    }

}
