package com.shq.leetcode.经典150题.哈希表.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 结果返回的是下标。。。
    public int[] twoSum(int[] nums, int target) {
        // 通过hashmap记录原属索引
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i=0; i< nums.length; i++) {
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{map.get(nums[left]), map.get(nums[right])};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1,-1};
    }

}
