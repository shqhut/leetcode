package com.shq.leetcode.经典150题.盛最多水的容器;

public class Solution {

    // 双指针
    public int maxArea(int[] height) {
        // 初始化指着在x轴两段
        int maxArea = 0, left = 0, right = height.length-1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
