package com.shq.leetcode.每日一题.最大字符串配对数目;

public class Solution {

    public int maximumNumberOfStringPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length-1; i++) {
            String reverseStr = reverseStr(words[i]);
            for (int j = i+1; j < words.length; j++) {
                if (words[j].equals(reverseStr)) {
                    result++;
                }
            }
        }
        return result;
    }

    // 字符串如何反转
    private String reverseStr(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

}
