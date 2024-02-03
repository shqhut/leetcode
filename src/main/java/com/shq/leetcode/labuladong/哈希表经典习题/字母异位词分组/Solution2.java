package com.shq.leetcode.labuladong.哈希表经典习题.字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> encodeToGroup = new HashMap<>();
        for (String str : strs) {
            String encode = encode(str);
            encodeToGroup.putIfAbsent(encode, new ArrayList<>());
            encodeToGroup.get(encode).add(str);
        }
        result.addAll(encodeToGroup.values());
        return result;
    }

    String encode(String str) {
        char[] count = new char[26];
        for (char c : str.toCharArray()) {
            int i = c - 'a';
            count[i]++;
        }
        return new String(count);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        Solution2 solution2 = new Solution2();
        solution2.groupAnagrams(strings);
    }
}
