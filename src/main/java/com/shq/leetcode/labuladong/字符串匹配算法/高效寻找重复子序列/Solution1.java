package com.shq.leetcode.labuladong.字符串匹配算法.高效寻找重复子序列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> res = new HashSet<>();
        // 把AGCT四个字符等价于0123四个数字，那么长度L=10的子序列就等价为一个10位数，这个数字可以唯一标识一个子串
        // 而且窗口移动过程，其实就是给这个数字最低位添加数字，并删除最高位数字的过程；
        int windows = 0;
        HashSet<Integer> seen = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            windows = convertIntLeft(windows, s.charAt(right));
            right++;
            while (right - left >= 10) {
                if (seen.contains(windows)) {
                    res.add(s.substring(left,right));
                } else {
                    seen.add(windows);
                }
                // 缩小窗口
                windows = convertIntRight(windows, s.charAt(left));
                left++;
            }
        }
        return new LinkedList<>(res);
    }

    // 在低位添加数字
    int convertIntLeft(int souceVal, char c) {
        int temp = 0;
        switch (c) {
            case 'A':
                temp = 0;
                break;
            case 'G':
                temp = 1;
                break;
            case 'C':
                temp = 1;
                break;
            case 'T':
                temp = 1;
                break;
        }
        souceVal = souceVal*4 + temp;
        return souceVal;
    }

    // 在高位移除数字
    int convertIntRight(int souceVal, char c) {
        int temp = 0;
        switch (c) {
            case 'A':
                temp = 0;
                break;
            case 'G':
                temp = 1;
                break;
            case 'C':
                temp = 1;
                break;
            case 'T':
                temp = 1;
                break;
        }
        souceVal = souceVal - temp * (int) Math.pow(4, 9);
        return souceVal;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<String> sequences = solution1.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(sequences);
    }

}
