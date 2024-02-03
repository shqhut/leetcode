package com.shq.leetcode.labuladong.哈希表经典习题.字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    //  该解法超出时间限制
    //  输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //  输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        // 保存字符串跟结果集
        Map<String,List<String>> strToList = new HashMap<>();
        // 便利过的字符串，同一种异位词只保留一个
        List<String> list = new ArrayList<>();
        for (String item : strs) {
            String head = null;
            // 去便利过的字符串集合中找匹配异位词
            for (String str : list) {
                if (check(str, item)) {
                    head = str;
                    break;
                }
            }
            List<String> group;
            if (head == null) {
                // 未匹配到异位词
                group = new ArrayList<>();
                group.add(item);
                strToList.put(item, group);
                list.add(item);
                result.add(group);
            } else {
                // 匹配到异位词，加入分组
                group = strToList.get(head);
                group.add(item);
            }
        }
        return result;
    }

    boolean check(String str1, String str2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : str1.toCharArray()) {
            int i = c - 'a';
            count1[i]++;
        }
        for (char c : str2.toCharArray()) {
            int i = c - 'a';
            count2[i]++;
        }
        for (int i=0; i<count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }



}
