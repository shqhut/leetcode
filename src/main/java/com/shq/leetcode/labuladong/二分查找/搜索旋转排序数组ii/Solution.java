package com.shq.leetcode.labuladong.二分查找.搜索旋转排序数组ii;

public class Solution {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            // 本题需要在计算 mid 之前收缩左右边界去重
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
                right--;
            }
            int mid = left + (right-left)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] <= nums[mid]) {
                // mid落在左半部分
                if (nums[mid] > target && target >= nums[left]) {
                    // target也落在
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                // mid落在右半部分
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.search(new int[]{1,3,5}, 1);
    }

}
