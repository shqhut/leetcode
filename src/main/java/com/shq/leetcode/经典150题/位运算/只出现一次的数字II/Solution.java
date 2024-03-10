package com.shq.leetcode.经典150题.位运算.只出现一次的数字II;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
    // 请你找出并返回那个只出现了一次的元素。
    // 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
    public int singleNumber(int[] nums) {
        int res = 0;
        Map<Integer,Integer> numCountMap = new HashMap();
        for (int num:nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : numCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return res;
    }

}
