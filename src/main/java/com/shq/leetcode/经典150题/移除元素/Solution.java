package com.shq.leetcode.经典150题.移除元素;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int[] newNums = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            newNums[index] = nums[i];
            index++;
        }
        nums = newNums;
        return newNums.length;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        Solution solution = new Solution();
        solution.removeElement(nums,3);
        for (int x:nums) {
            System.out.print(x);
        }
    }

}
