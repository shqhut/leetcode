package com.shq.leetcode.经典150题.移除元素;

public class Solution2 {

    public int removeElement(int[] nums, int val) {
        // 双指针技巧
        int left = 0,right = 0;
        while (left < nums.length) {
            if (nums[left] == val) {
                while (right < nums.length) {
                    if (right > left && nums[right] != val) {
                        nums[left] = nums[right];
                        nums[right] = val;
                        break;
                    }
                    right++;
                }
            }
            if (right == nums.length-1) {
                break;
            }
            left++;
        }
        return left+1;
    }

}
