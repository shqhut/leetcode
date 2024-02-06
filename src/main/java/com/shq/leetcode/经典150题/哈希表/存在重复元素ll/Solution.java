package com.shq.leetcode.经典150题.哈希表.存在重复元素ll;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
    // 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
    // 如果存在，返回 true ；否则，返回 false 。
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 思路：遍历nums，利用hash表保存value -> index；
        // 当遇到nums[j] == nums[i]，比较j-i是否<=k
        // 相等范围true，不相等，更新value对应下标为当前值，abs(i-j) <= k j一定是i前面的最大值
        // nums = [1,2,3,1], k = 3
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                Integer j = map.get(value);
                if (Math.abs(i-j) <= k) {
                    return true;
                } else {
                    map.put(value, i);
                }
            } else {
                map.put(value, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        solution.containsNearbyDuplicate(nums, k);
    }

}
