package com.shq.leetcode.labuladong.字符串匹配算法.重复的DNA序列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        // 使用hashSet，防止记录重复结果
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i+10 <= s.length(); i++) {
            // subString方法，截取字符串的方式为[start,end)
            String temp = s.substring(i,i+10);
            if (seen.contains(temp)) {
                res.add(temp);
            } else {
                seen.add(temp);
            }
        }
        return new LinkedList<>(res);
    }

}
