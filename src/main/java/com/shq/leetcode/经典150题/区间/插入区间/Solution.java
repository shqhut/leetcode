package com.shq.leetcode.经典150题.区间.插入区间;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
    // 在列表中插入一个新的区间，你需要确保列表中的区间仍然
    // 有序且不重叠（如果有必要的话，可以合并区间）。
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        // 只需要找到跟新区间相交的区间，将相交的区间合并成一个大区间
        // 大区间及其他区间组成结果
        for (int i = 0; i < intervals.length; i++) {
            // 判断
            int[] cur = intervals[i];
            if (newInterval[0] <= cur[0] ) {

            }
        }
        List<int[]> res = new LinkedList<>();

        return res.toArray(new int[res.size()][]);
    }

}
