package com.shq.leetcode.labuladong.滑动窗口.最长无重复子串;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    // 关键点：何时缩小窗口——当窗口中存在重复元素时
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> windows = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            // 添加到窗口中的元素
            char c = s.charAt(right);
            // 更新窗口数据
            windows.put(c, windows.getOrDefault(c,0)+1);
            right++;
            while (windows.get(c) > 1){
                char d = s.charAt(left);
                // 更新窗口数据
                windows.put(d, windows.get(d)-1);
                left++;
            }
            // 更新答案
            res = Math.max(res, right-left);
        }
        return res;
    }

}
