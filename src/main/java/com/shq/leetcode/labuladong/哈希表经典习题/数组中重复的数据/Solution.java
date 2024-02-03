package com.shq.leetcode.labuladong.哈希表经典习题.数组中重复的数据;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    //  给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
    //  请你找出所有出现 两次 的整数，并以数组形式返回。
    //  你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> numToCount = new HashMap<>();
        for (Integer n : nums) {
            numToCount.put(n, numToCount.getOrDefault(n,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : numToCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

}
