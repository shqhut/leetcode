package com.shq.leetcode.经典150题.区间.汇总区间;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 给定一个  无重复元素 的 有序 整数数组 nums 。
    // 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
    // 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
    // 并且不存在属于某个范围但不属于 nums 的数字 x 。
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        int start = 0,end = 0;
        for (int i = 0; i < nums.length; i++) {
            int nextVal = end + 1;
            if (res.isEmpty()) {
                // 初始阶段
                start = nums[i];
            } else if (nextVal != nums[i]) {
                // 未连贯，将旧区间存入结果集
                if (start == end) {
                    res.add(start + "");
                }else {
                    res.add(start + "->" + end);
                }
                // 设置新区间
                start = nums[i];
            }
            end = nums[i];
        }
        // 未连贯，将旧区间存入结果集
        if (start == end) {
            res.add(start + "");
        }else {
            res.add(start + "->" + end);
        }
        return res;
    }

}
