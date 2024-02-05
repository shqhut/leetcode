package com.shq.leetcode.labuladong.哈希表经典习题.数组中重复的数据;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    // 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
    //你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int[] seen = new int[nums.length+1];
        for (int i : nums) {
            if (seen[i] == 0) {
                seen[i] = i;
            }else {
                result.add(i);
            }
        }
        return result;
    }

}
