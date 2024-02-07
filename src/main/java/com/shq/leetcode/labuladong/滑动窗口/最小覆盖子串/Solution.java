package com.shq.leetcode.labuladong.滑动窗口.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //  给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
    //  如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    //  注意：
    //  对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    //  如果 s 中存在这样的子串，我们保证它是唯一的答案。
    public String minWindow(String s, String t) {
        // 输入：s = "ADOBECODEBANC", t = "ABC"
        // 输出："BANC"
        // 记录窗口数据，窗口内字符及其数量的map
        Map<Character, Integer> windows = new HashMap<>();
        // 目标字符串各个字符及对应数量
        Map<Character, Integer> need = new HashMap<>();
        for (char c:t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        // todo 难点在于如何维护最优解，也是滑动窗口框架之外的东西；
        int start = 0, length = Integer.MAX_VALUE;
        int vaild = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c,0)+1);
            if (need.containsKey(c)) {
                if (need.get(c).equals(windows.get(c))) {
                    vaild++;
                }
            }
            // 扩大窗口
            right++;
            while (left < right && vaild == need.size()) {
                // 更新最小覆盖子串
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                // 将要剔除的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 更新窗口数据
                if (need.containsKey(d)) {
                    if (need.get(d).equals(windows.get(d))) {
                        vaild--;
                    }
                    windows.put(d, windows.get(d)-1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start,start+length);
    }

}
