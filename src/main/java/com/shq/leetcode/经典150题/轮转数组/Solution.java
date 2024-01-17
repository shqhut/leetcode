package com.shq.leetcode.经典150题.轮转数组;

public class Solution {

    public void rotate(int[] nums, int k) {
        // 数组的最后k个元素放到数组前k个，后面的元素后移
        int n = nums.length;
        k = k % n;
        // 保存nums[0,...,n-k-1]
        int[] temp = new int[n-k];
        // 保存nums[n-k,...n-1]
        int[] temp2 = new int[k];
        for (int i = 0; i < n - k; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            temp2[i] = nums[n-k+i];
        }

        for (int i = 0; i < n; i++) {
            if (i<k) {
                // nums[0,k-1]
                nums[i] = temp2[i];
            }else {
                // nums[k,...n-1]
                nums[i] = temp[i-k];
            }
        }
    }

}
