package com.shq.leetcode.经典150题.哈希表.单词规律;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
    //这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if (pattern.length() != sArray.length) {
            return false;
        }
        // pattern转数组
        String[] patternArray = new String[pattern.length()];
        for (int i = 0; i < pattern.length(); i++) {
            patternArray[i] = String.valueOf(pattern.charAt(i));
        }
        return checkPattern(patternArray,sArray) && checkPattern(sArray, patternArray);
    }

    boolean checkPattern(String[] s, String[] t) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            String s2 = t[i];
            if (map.containsKey(s1)) {
                if (!map.get(s1).equals(s2)) {
                    return false;
                }
            } else {
                map.put(s1, s2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String pattern = "abba";
        String s = "dog cat cat dog";
        solution.wordPattern(pattern, s);
    }

}
