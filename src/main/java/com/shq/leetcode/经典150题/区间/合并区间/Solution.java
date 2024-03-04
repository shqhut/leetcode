package com.shq.leetcode.经典150题.区间.合并区间;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
    // 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        // 按区间的start升序排序
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // res最后一个元素
            int[] last = res.get(res.size()-1);
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1],curr[1]);
            } else {
                // 加入下一个待处理区间
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
