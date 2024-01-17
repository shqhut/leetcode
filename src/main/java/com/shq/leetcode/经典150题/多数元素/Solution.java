package com.shq.leetcode.经典150题.多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i:nums) {
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }
        int n = nums.length / 2;
        for (Map.Entry<Integer,Integer> entry:countMap.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
