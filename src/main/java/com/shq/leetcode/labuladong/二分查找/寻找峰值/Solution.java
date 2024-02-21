package com.shq.leetcode.labuladong.二分查找.寻找峰值;

public class Solution {

    // 峰值元素是指其值严格大于左右相邻值的元素。
    // 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
    // 你可以假设 nums[-1] = nums[n] = -∞ 。
    // 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
    // 输入：nums = [1,2,3,1]
    // 输出：2
    // 解释：3 是峰值元素，你的函数应该返回其索引 2。
    public int findPeakElement(int[] nums) {
        // 思路：不要考虑left、right，单纯考虑mid周边的情况。
        // 具体来说，我们计算nums[mid]和nums[mid+1]这两个元素的相对大小，即可得到mid附近的元素走势：
        // 如果走势下行（nums[mid] > nums[mid+1]）说明mid为峰值或峰值右边的元素，收缩right=mid；
        // 如果走势上行（nums[mid] < nums[mid+1]）说明mid为峰值左边的元素，收缩left=mid+1；
        int left = 0, right = nums.length-1;
        // 因为题目必然有解，所以设置 left == right 为结束条件
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < nums[mid+1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
