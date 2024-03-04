package com.shq.leetcode.经典150题.区间.汇总区间;

import java.util.LinkedList;
import java.util.List;

public class Standard {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        int i = 0, n = nums.length;
        while (i<n) {
            int low = i;
            i++;
            while (i<n && nums[i] < nums[i-1] + 1) {
                i++;
            }
            int high = i-1;
            StringBuilder stringBuilder = new StringBuilder(Integer.valueOf(nums[low]).toString());
            if (low < high) {
                stringBuilder.append("->").append(Integer.valueOf(nums[high]).toString());
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }
}
