package com.shq.leetcode.经典150题.最长公共前缀;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        // strs = ["flower","flow","flight"]
        // "fl"
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            if (str.equals(prefix)) {
                continue;
            }
            // 求str和prefix的公共前缀
            String temp = "";
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (i >= str.length() || str.charAt(i) != c) {
                    break;
                }
                temp += c;
            }
            prefix = temp;
        }
        return prefix;
    }

}
