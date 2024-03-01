package com.shq.leetcode.labuladong.字符串匹配算法.重复的DNA序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
    // 例如，"ACGAATTCCG" 是一个 DNA序列 。
    // 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
    // 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        // 使用hashSet，防止记录重复结果
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i+10 <= s.length(); i++) {
            // subString方法，截取字符串的方式为[start,end)
            String temp = s.substring(i,i+10);
            if (seen.contains(temp)) {
                res.add(temp);
            }else {
                seen.add(temp);
            }
        }
        return new LinkedList<>(res);
    }
}
