package com.shq.leetcode.labuladong.滑动窗口.字符串的排列;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //  给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
    //  如果是，返回 true ；否则，返回 false 。
    //  换句话说，s1 的排列之一是 s2 的 子串 。
    public boolean checkInclusion(String s1, String s2) {
        //  输入：s1 = "ab" s2 = "eidbaooo"
        //  输出：true
        //  输入：s1= "ab" s2 = "eidboaoo"
        //  输出：false
        // 相当于给你一个S和一个T，请问你S中是否存在一个子串，包含T中所有字符且不包含其他字符
        // 滑动窗口，只不过窗口大小应控制在s1.length，即缩小窗口的时机为right-left >= s1.length()
        // 记录窗口数据，窗口内字符及其数量的map
        Map<Character, Integer> windows = new HashMap<>();
        // 目标字符串各个字符及对应数量
        Map<Character, Integer> need = new HashMap<>();
        for (char c:s1.toCharArray()) {
            need.put(c, need.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        int vaild = 0;
        while (right < s2.length()) {
            // 需要加入窗口的字符
            char c = s2.charAt(right);
            // 加入窗口
            windows.put(c, windows.getOrDefault(c,0)+1);
            right++;
            if (need.containsKey(c)) {
                if (need.get(c).equals(windows.get(c))) {
                    vaild++;
                }
            }
            // 判断是否需要缩小窗口
            while (right-left >= s1.length()) {
                if (vaild == need.size()) {
                    return true;
                }
                // 移出窗口的字符
                char d = s2.charAt(left);
                if (need.containsKey(d)) {
                    if (need.get(d).equals(windows.get(d))) {
                        vaild--;
                    }
                    windows.put(d, windows.get(d)-1);
                }
                // 缩小窗口
                left++;
            }
        }
        return false;
    }
}
