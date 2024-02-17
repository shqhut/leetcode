package com.shq.leetcode.经典150题.二分查找.寻找旋转排序数组中的最小值;

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        // 中点有两中情况：
        // 1、落在最小值左边，nums[mid] < nums[right] 中点右边的元素不用考虑，即right = mid
        // 2、落在最小值右边，nums[mid] > nums[right] 中点左边的元素不用考虑，即left = mid + 1
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,1,2};
        solution.findMin(nums);
    }
}
