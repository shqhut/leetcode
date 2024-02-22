package com.shq.leetcode.labuladong.二分查找.山脉数组的峰顶索引;

public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        // 二分查找
        // arr[mid] > arr[mid+1] 说明mid为山脉峰顶或峰顶右边的元素，right = mid
        // arr[mid] <= arr[mid+1] 说明mid为山脉数组峰顶左边的元素，left = mid+1
        int left = 0, right = arr.length-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (arr[mid] > arr[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
