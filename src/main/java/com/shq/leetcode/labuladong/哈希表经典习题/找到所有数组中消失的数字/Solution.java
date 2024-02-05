package com.shq.leetcode.labuladong.哈希表经典习题.找到所有数组中消失的数字;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
    // 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int[] seen = new int[nums.length+1];
        for (Integer i : nums) {
            seen[i] = i;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (seen[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

}
