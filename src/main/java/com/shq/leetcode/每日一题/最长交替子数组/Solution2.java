package com.shq.leetcode.每日一题.最长交替子数组;

public class Solution2 {

    public int alternatingSubarray(int[] nums) {
        // 交替子数组，从s[1]-s[0]=diff s[2]-s[1]=diff*-1
        // case1： 3 4 3 4 5 -> 4 5虽然跟前面的元素无法构成交替子数组，但是可以作为下一个子序列的开始两个元素
        // case2：1 3 5 7 -> 交替子数组长度一直为1，说明不存在交替子数组，返回-1
        // case：1 2 4 -> 2 4开始无法跟前面元素构成交替子数组，且2 4不符合交替子序列，因此4应该作为下一次判断的第一个元素
        int ans = -1;
        int n = nums.length;
        // 交替值
        int diff = 1;
        int temp = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i-1] == diff) {
                temp++;
                diff = diff * -1;
            } else if (nums[i] - nums[i-1] == 1) {
                temp = 2;
                diff = -1;
            } else {
                temp = 1;
                diff = 1;
            }
            ans = Math.max(ans, temp);
        }
        return ans == 1 ? -1 : ans;
    }

}
