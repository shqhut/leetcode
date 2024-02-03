package com.shq.leetcode.经典150题.哈希表.两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        // 数组下标和值的映射
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            boolean flag = map.containsKey(target - nums[i]);
            if (flag) {
                return new int[]{map.get(target - nums[i]),i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }

}
