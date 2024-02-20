package com.shq.leetcode.labuladong.二分查找.分割数组的最大值;

import java.util.Map;

public class Solution {

    // 给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。
    // 设计一个算法使得这 k 个子数组各自和的最大值最小。
    public int splitArray(int[] nums, int k) {
        // 类似货船运送包裹，货船每天运送走的货物是nums的一个子数组，在m天内运完，就是将nums划分成m个子数组
        // 让货船载重尽可能小，就是让所有子数组中最大的那个子数组元素和尽可能小
        int sum = 0,max = 0;
        for(int n:nums) {
            sum+=n;
            max = Math.max(max,n);
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (split(nums,mid) > k){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int split(int[] nums, int m) {
        int res = 1;
        int temp = 0;
        for(int n:nums) {
            if (temp + n <= m) {
                temp+=n;
            }else {
                res++;
                temp = n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        int k = 2;
        Solution solution = new Solution();
        int i = solution.splitArray(nums, k);
        System.out.println(i);
    }

}
