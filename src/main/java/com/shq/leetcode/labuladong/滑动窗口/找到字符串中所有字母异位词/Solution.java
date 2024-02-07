package com.shq.leetcode.labuladong.滑动窗口.找到字符串中所有字母异位词;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    //  给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    //  异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
    //  输入: s = "cbaebabacd", p = "abc"
    //  输出: [0,6]
    //  输入: s = "abab", p = "ab"
    //  输出: [0,1,2]
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        // 记录窗口数据，窗口内字符及其数量的map
        Map<Character, Integer> windows = new HashMap<>();
        // 目标字符串各个字符及对应数量
        Map<Character, Integer> need = new HashMap<>();
        for (char c:p.toCharArray()) {
            need.put(c, need.getOrDefault(c,0)+1);
        }
        int left = 0, right = 0;
        int vaild = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c,windows.getOrDefault(c,0)+1);
            if (need.containsKey(c)) {
                if (need.get(c).equals(windows.get(c))) {
                    vaild++;
                }
            }
            right++;
            // 缩小窗口
            while (right-left>=p.length()) {
                if (vaild == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                if (need.containsKey(d)) {
                    if (need.get(d).equals(windows.get(d))) {
                        vaild--;
                    }
                    windows.put(d, windows.get(d)-1);
                }
                left++;
            }
        }
        return res;
    }

}
