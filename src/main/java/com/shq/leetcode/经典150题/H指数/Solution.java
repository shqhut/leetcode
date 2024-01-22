package com.shq.leetcode.经典150题.H指数;

import java.util.Arrays;

public class Solution {

    public int hIndex(int[] citations) {
        // H指数：至少发表h篇论文，且至少有h篇论文被引用次数大于等于h
        Arrays.sort(citations);
        int i = citations.length-1;
        int h = 0;
        while (i >= 0 && citations[i] > h) {
            i--;
            h++;
        }
        return h;
    }

}
