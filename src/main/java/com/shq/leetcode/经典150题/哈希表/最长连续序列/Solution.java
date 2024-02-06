package com.shq.leetcode.经典150题.哈希表.最长连续序列;

import java.util.HashSet;
import java.util.Set;

class Solution {

    // 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    // 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
    public int longestConsecutive(int[] nums) {
        // 记录最长序列长度
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        for (int n:nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int currentLength = 1;
            // 只有当前元素前驱不存在，才进行遍历，防止已计算过长度的序列子序列重复遍历
            if (!set.contains(currentNum-1)) {
                while (set.contains(currentNum+1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(currentLength, maxLength);
            }

        }
        return maxLength;
    }

}
