package com.shq.leetcode.每日一题.最长交替子数组;

public class Solution {

    public int alternatingSubarray(int[] nums) {
        // 题目要求返回所有交替子数组的最长长度，我们可以利用双层循环。
        // 外层的循环遍历数组每一个的下标，使其作为交替子数组的第一个下标firstIndex。
        // 内层循环则从firstIndex往后遍历，判断接下来的元素是否满足交替子数组的条件。
        // 是的话则更新最长长度，不满足的的话则跳出内层循环，继续外层循环。
        // 外层循环遍历完后，返回最长长度。
        int m = 0;
        int temp = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-i; j++) {
                // 判断以j为firstIndex交替子数组长度
                // 奇数位下标-偶数位下标=1 偶数位下表-奇数位下标=-1
                if ((j%2 == 0 && nums[j+1] - nums[j] == 1) || (j%2 == 1 && nums[j+1] - nums[j] == -1) ) {
                    temp++;
                } else {
                    break;
                }
            }
            m = Math.max(m,temp);
            temp = 0;
        }
        return m;
    }



}
