package com.shq.leetcode.经典150题.删除有序数组的重复项;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[slow] != nums[i]) {
                slow++;
                nums[slow] = nums[i];
            }
        }
        return slow+1;
    }

}
