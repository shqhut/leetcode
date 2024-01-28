package com.shq.leetcode.经典150题.两数之和输入有序数组;

class Solution {

    public int[] twoSum(int[] numbers, int target) {
        // numbers = [2,7,11,15], target = 9 输出[1,2]
        // 双指针
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{};
    }

}