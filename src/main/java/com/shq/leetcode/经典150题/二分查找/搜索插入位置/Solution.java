package com.shq.leetcode.经典150题.二分查找.搜索插入位置;

public class Solution {

    // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    // 请必须使用时间复杂度为 O(log n) 的算法。
    public int searchInsert(int[] nums, int target) {
        // [1,3,5,6] 5 => 2
        // [1,3,5,6] 2 => 1
        // [1,3,5,6] 7 => 4
        int left = 0, right = nums.length-1;
        // left == right时跳出循环
        while (left < right) {
            int mid = (right+left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
        }
        return nums[left] < target ? left+1 : left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        Solution solution = new Solution();
        int i = solution.searchInsert(nums, 7);
        System.out.println(i);
    }

}
